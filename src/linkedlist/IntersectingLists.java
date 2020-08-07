package linkedlist;

public class IntersectingLists {

    static class ListDetails {
        int length;
        Node tail;

        ListDetails(int length, Node tail) {
            this.length = length;
            this.tail = tail;
        }

    }

    /**
     * func : getIntersection
     * Approach: Efficient approach
     * Time: O(n) if n > m
     * Aux Space: O(1)
     *
     * @param head1 {@link Node}
     * @param head2 {@link Node}
     * @return Node
     */
    static Node getIntersection(Node head1, Node head2) {

        if (getLengthNTail(head1).tail != getLengthNTail(head2).tail) {
            return null;
        }

        Node smallList = getLengthNTail(head1).length > getLengthNTail(head2).length ? head2 : head1;
        Node longList = getLengthNTail(head1).length > getLengthNTail(head2).length ? head1 : head2;

        int diff = getLengthNTail(longList).length - getLengthNTail(smallList).length;
        while (diff-- > 0) {
            longList = longList.next;
        }

        while (smallList != longList) {
            smallList = smallList.next;
            longList = longList.next;
        }

        return smallList;
    }


    static ListDetails getLengthNTail(Node head) {
        int length = 0;
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        return new ListDetails(length + 1, curr);
    }

    public static void main(String[] args) {
        List list1 = new List();
        list1.insertBegin(20);
        list1.insertBegin(10);
        list1.insertBegin(5);
        list1.insertEnd(55);
        list1.insertEnd(60);
        list1.insertEnd(95);

        List list2 = new List();
        list2.insertBegin(8);
        list2.insertBegin(19);

        list2.tail.next = list1.head.next.next.next;

        list1.printList();
        list2.printList();


        Node node = getIntersection(list1.head, list2.head);

        System.out.println("List1 and List2 intersect at : " + (node != null ? node.data : "No intersection point found"));
    }

}
