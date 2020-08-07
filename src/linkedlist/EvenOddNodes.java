package linkedlist;

public class EvenOddNodes {

    /**
     * func : segregateEvenOdd
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head Node
     * @return Node
     */
    static Node segregateEvenOdd(Node head) {
        Node eS = null, eE = null, oS = null, oE = null;
        for (Node curr = head; curr != null; curr = curr.next) {
            int x = curr.data;
            if (x % 2 == 0) {
                if (eS == null) {
                    eS = curr;
                    eE = eS;
                } else {
                    eE.next = curr;
                    eE = eE.next;
                }
            } else {
                if (oS == null) {
                    oS = curr;
                    oE = oS;
                } else {
                    oE.next = curr;
                    oE = oE.next;
                }
            }
        }

        if (oS == null || eS == null) {
            return head;
        }

        eE.next = oS;
        oE.next = null;

        return eS;
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
        list.head = segregateEvenOdd(list.head);
        System.out.println("After segregation: ");
        list.printList();
    }
}
