package linkedlist;

import java.util.ArrayDeque;

class PNode {
    char data;
    PNode next;

    PNode(char d) {
        data = d;
        next = null;
    }
}

public class Palindrome {

    public static void traverse(PNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        System.out.print(head.data + " -> ");
        traverse(head.next);
    }

    /**
     * func : isPalindrome_n
     * Approach: Naive approach
     * Time: O(n)
     * Aux Space: O(n)
     *
     * @param head {@link PNode}
     * @return boolean
     */
    static boolean isPalindrome_n(PNode head) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (PNode curr = head; curr != null; curr = curr.next) {
            stack.push(curr.data);
        }
        for (PNode curr = head; curr != null; curr = curr.next) {
            if (stack.pop() != curr.data) {
                return false;
            }
        }
        return true;
    }

    /**
     * func : isPalindrome_e
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head {@link PNode}
     * @return boolean
     */
    static boolean isPalindrome_e(PNode head) {

        PNode fast = head;
        PNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        PNode rev = reverseList(slow.next);

        PNode curr = head;
        while (rev != null) {
            if (curr.data != rev.data)
                return false;
            rev = rev.next;
            curr = curr.next;
        }
        return true;
    }

    private static PNode reverseList(PNode head) {
        PNode curr = head;
        PNode prev = null;

        while (curr != null) {
            PNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        PNode head = new PNode('r');
        head.next = new PNode('a');
        head.next.next = new PNode('d');
        head.next.next.next = new PNode('a');
        head.next.next.next.next = new PNode('r');

        traverse(head);
        System.out.println("Is Palindrome: " + isPalindrome_e(head));

    }


}
