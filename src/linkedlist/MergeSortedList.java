package linkedlist;

public class MergeSortedList {

    /**
     * func : sortedMerge
     * Approach: Efficient approach
     * Time: O(m+n)
     * Aux Space: O(1)
     *
     * @param a {@link Node}
     * @param b {@link Node}
     * @return Node
     */
    static Node sortedMerge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node head = null;
        Node tail = null;

        if (a.data <= b.data) {
            head = tail = a;
            a = a.next;
        } else {
            head = tail = b;
            b = b.next;
        }

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                tail = a;
                a = a.next;
            } else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }

        if (a == null) {
            tail.next = b;
        } else
            tail.next = a;

        return head;
    }

    public static void main(String[] args) {
        List list1 = new List();
        list1.insertBegin(20);
        list1.insertBegin(10);
        list1.insertBegin(5);
        list1.insertEnd(55);
        list1.insertEnd(60);
        list1.insertEnd(65);

        List list2 = new List();
        list2.insertBegin(19);
        list2.insertBegin(8);
        list2.insertEnd(70);
        list2.insertEnd(80);
        list2.insertEnd(95);

        list1.printList();
        list2.printList();

        List list = new List();

        list.head = sortedMerge(list1.head, list2.head);

        list.printList();

    }

}
