package linkedlist;

public class PairWiseSwap {

    /**
     * func : pairwiseSwap_m1
     * Approach: Efficient approach(Not in case of large string
     * or numbers to swap)
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head {@link Node}
     */
    static void pairwiseSwap_m1(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }
    }

    /**
     * func : pairwiseSwap_m2
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head {@link Node}
     */
    static Node pairwiseSwap_m2(Node head) {
        Node curr = head.next.next;
        Node prev = head;
        head = head.next;
        head.next = prev;

        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            Node next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }

        prev.next = curr;
        return head;
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
        list.head = pairwiseSwap_m2(list.head);
        System.out.println("After pair wise swapping : ");
        list.printList();

    }
}
