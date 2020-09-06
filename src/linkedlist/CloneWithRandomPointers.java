package linkedlist;

import java.util.HashMap;
import java.util.Map;

class RNode {
    int data;
    RNode next, random;

    RNode(int data) {
        this.data = data;
    }
}

public class CloneWithRandomPointers {

    // Recursive function to print a linked list
    public static void traverse(RNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        // print current node data and random pointer data
        if (head.random != null) {
            System.out.print(head.data + "(" + head.random.data + ") -> ");
        } else {
            System.out.print(head.data + "(" + "X" + ") -> ");
        }

        // recur for the next node
        traverse(head.next);
    }


    /**
     * func : cloneLinkedList_m1
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(n)
     *
     * @param head
     * @return
     */
    public static RNode cloneLinkedList_m1(RNode head) {
        Map<RNode, RNode> map = new HashMap<>();

        for (RNode curr = head; curr != null; curr = curr.next) {
            map.put(curr, new RNode(curr.data));
        }

        RNode cloneCurr = null;

        for (RNode curr = head; curr != null; curr = curr.next) {

            cloneCurr = map.get(curr);
            cloneCurr.next = map.get(curr.next);
            cloneCurr.random = map.get(curr.random);
        }

        return map.get(head);
    }

    /**
     * func : cloneLinkedList_m2
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head
     * @return
     */
    public static RNode cloneLinkedList_m2(RNode head) {

        for (RNode curr = head; curr != null; ) {
            RNode next = curr.next;
            curr.next = new RNode(curr.data);
            curr.next.next = next;
            curr = next;
        }

        for (RNode curr = head; curr != null; curr = curr.next.next) {
            curr.next.random = curr.random != null ? curr.random.next : null;
        }

        RNode cloneHead = head.next;
        RNode cloneCurr = cloneHead;

        for (RNode curr = head; curr != null && cloneCurr != null; curr = curr.next, cloneCurr = cloneCurr.next) {
            RNode next = curr.next;
            curr.next = curr.next != null ? curr.next.next : null;
            cloneCurr.next = cloneCurr.next != null ? cloneCurr.next.next : null;
        }

        return cloneHead;
    }

    public static void main(String[] args) {
        RNode head = new RNode(1);
        head.next = new RNode(2);
        head.next.next = new RNode(3);
        head.next.next.next = new RNode(4);
        head.next.next.next.next = new RNode(5);

        head.random = head.next.next.next;
        head.next.next.random = head.next;

        System.out.println("Original Linked List:");
        traverse(head);

        RNode clone = cloneLinkedList_m1(head);

        System.out.println("\nCloned Linked List:");
        traverse(clone);

        RNode clone2 = cloneLinkedList_m2(head);

        System.out.println("\nCloned Linked List2:");
        traverse(clone2);
    }
}