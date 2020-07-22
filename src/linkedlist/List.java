package linkedlist;

public class List {
    Node head;

    void insertBegin(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
    }

    void insertEnd(int x) {
        Node temp = new Node(x);
        if (head == null) {
            head = temp;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
    }

    void printList() {
        Node curr = head;
        while (curr.next != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println(curr.data);
    }

    public static void main(String[] args) {
        List list = new List();
        list.insertBegin(20);
        list.insertBegin(10);
        list.insertBegin(5);
        list.insertEnd(55);
        list.insertEnd(60);


        list.printList();

    }

}
