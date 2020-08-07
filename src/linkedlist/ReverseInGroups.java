package linkedlist;

public class ReverseInGroups {

    /**
     * func : reverseInGroupRecur
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head Node
     * @param k    int
     * @return Node
     */
    static Node reverseInGroupRecur(Node head, int k) {
        Node curr = head;
        Node prev = null, next = null;

        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            Node rest_head = reverseInGroupRecur(next, k);
            head.next = rest_head;
        }
        return prev;
    }

    /**
     * func : reverseInGroupItr
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head Node
     * @param k    int
     * @return Node
     */
    static Node reverseInGroupItr(Node head, int k) {
        Node curr = head;
        Node prevFirst = null;
        boolean isFirst = true;
        while (curr != null) {
            Node first = curr, prev = null;
            int count = 0;
            while (curr != null && count < k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (isFirst) {
                head = prev;
                prevFirst = first;
                isFirst = false;
            } else {
                prevFirst.next = prev;
                prevFirst = first;
            }
        }
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

        int k = 3;

        list.printList();
        list.head = reverseInGroupItr(list.head, k);
        System.out.println("Reversed Linked List : ");
        list.printList();
    }

}
