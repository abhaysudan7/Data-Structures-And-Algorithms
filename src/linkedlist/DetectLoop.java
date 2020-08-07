package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectLoop {

    /**
     * func : detectLoop_m1
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head Node
     * @return boolean
     */
    static boolean detectLoop_m1(Node head) {
        Node temp = new Node(0);
        Node curr = head;
        while (curr != null) {
            if (curr.next == temp)
                return true;
            if (curr.next == null)
                return false;

            Node next = curr.next;
            curr.next = temp;
            curr = next;
        }
        return false;
    }

    /**
     * func : detectLoop_m2
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(n)
     *
     * @param head Node
     * @return boolean
     */
    static boolean detectLoop_m2(Node head) {

        Set<Node> set = new HashSet<>();

        for (Node curr = head; curr != null; curr = curr.next) {
            if (set.contains(curr.next))
                return true;
            set.add(curr);
        }
        return false;
    }

    /**
     * func : detectLoop_m3
     * Approach: Efficient approach(Floyd Cycle Detection)
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head Node
     * @return boolean
     */
    static boolean detectLoop_m3(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List list = new List();
        list.insertBegin(20);
        list.insertBegin(10);
        list.insertBegin(5);
        list.insertEnd(55);
        list.insertEnd(60);
        list.insertEnd(95);

        list.tail.next = list.head.next.next.next;

        System.out.println("Is loop present? " + detectLoop_m3(list.head));
    }
}
