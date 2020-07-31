package linkedlist;


import java.util.ArrayList;

public class ReverseLinkedList {

    /**
     * func : reverseList_n
     * Approach: Naive approach
     * Time: O(n^2)
     * Aux Space: O(n)
     *
     * @param head Node
     * @return Node
     */
    static Node reverseList_n(Node head) {
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
     * func : reverseList_e
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head Node
     * @return Node
     */
    static Node reverseList_e(Node head) {
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


    public static void main(String[] args) {
        List list = new List();
        list.insertBegin(20);
        list.insertBegin(10);
        list.insertBegin(5);
        list.insertEnd(55);
        list.insertEnd(60);
        list.insertEnd(95);


        list.printList();
        list.head = reverseList_e(list.head);
        System.out.println("Reversed Linked List : ");
        list.printList();

    }

}
