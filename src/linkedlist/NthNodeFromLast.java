package linkedlist;

public class NthNodeFromLast {

    static void printNthFromEnd_m1(Node head, int n) {
        int len = 0;
        for (Node curr = head; curr != null; curr = curr.next)
            len++;

        if (len < n)
            return;
        Node curr = head;
        for (int i = 0; i < (len - 3); i++) {
            curr = curr.next;
        }
        System.out.println(n + "th node from end is : " + curr.data);
    }

    static void printNthFromEnd_m2(Node head, int n) {
        if (head == null)
            return;
        Node first = head;
        Node second = head;

        for (int i = 0; i < n; i++) {
            if (second == null) return;
            second = second.next;
        }

        while (second != null) {
            second = second.next;
            first = first.next;
        }
        System.out.println(n + "th node from end is : " + first.data);
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
        printNthFromEnd_m2(list.head, 3);
    }
}
