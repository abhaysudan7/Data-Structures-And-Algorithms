package linkedlist;


import java.util.ArrayList;

public class ReverseLinkedList {

    /**
     * func : reverseListITR_n
     * Approach: Naive approach
     * Time: O(n^2)
     * Aux Space: O(n)
     *
     * @param head Node
     * @return Node
     */
    static Node reverseListITR_n(Node head) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (Node curr = head; curr != null; curr = curr.next) {
            al.add(curr.data);
        }

        for (Node curr = head; curr != null; curr = curr.next) {
            curr.data = al.remove(al.size() - 1);
        }
        return head;
    }


    /**
     * func : reverseListITR_e
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head Node
     * @return Node
     */
    static Node reverseListITR_e(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    /**
     * func : reverseListRecur_m1
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head Node
     * @return Node
     */
    static Node reverseListRecur_m1(Node head) {
        if (head == null || head.next == null)
            return head;

        Node rest_head = reverseListRecur_m1(head.next);
        head.next.next = head;
        head.next = null;
        return rest_head;
    }

    /**
     * func : reverseListRecur_m2
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param curr Node
     * @param prev Node
     * @return Node
     */
    static Node reverseListRecur_m2(Node curr, Node prev) {

        if (curr == null) return prev;

        Node next = curr.next;
        curr.next = prev;
        return reverseListRecur_m2(next, curr);
    }


    public static void main(String[] args) {
        List list = new List();
        list.insertBegin(20);
        list.insertBegin(10);
        list.insertBegin(5);
        list.insertEnd(55);
        list.insertEnd(60);
        list.insertEnd(95);


        list.printList();
        list.head = reverseListRecur_m2(list.head, null);
        System.out.println("Reversed Linked List : ");
        list.printList();

    }

}
