package linkedlist;

public class MiddleOfLIst {

    static void middleElem_m1(Node head) {
        if (head == null)
            return;
        int count = 0;
        Node curr;
        for (curr = head; curr != null; curr = curr.next)
            count++;

        curr = head;
        for (int i = 0; i < count / 2; i++) {
            curr = curr.next;
        }
        System.out.println(curr.data);
    }

    static void middleElem_m2(Node head) {
        if (head == null)
            return;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.data);
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

        System.out.print("\nMiddle Element is : ");
        middleElem_m2(list.head);
    }

}
