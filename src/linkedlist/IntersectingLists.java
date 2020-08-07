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

        if (head1 == null || head2 == null) return null;

        ListDetails ld1 = getLengthNTail(head1);
        ListDetails ld2 = getLengthNTail(head2);


        if (ld1.tail != ld2.tail) {
            return null;
        }


        Node shorter = ld1.length > ld2.length ? head2 : head1;
        Node longer = ld1.length > ld2.length ? head1 : head2;

        longer = getKthNode(longer, Math.abs(ld1.length - ld2.length));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter;
    }

    static Node getKthNode(Node head, int k) {
        Node curr = head;
        while (k > 0 && curr != null) {
            curr = curr.next;
            k--;
        }
        return curr;
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
