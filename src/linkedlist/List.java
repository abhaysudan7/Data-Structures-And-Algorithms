package linkedlist;

public class List {
    Node head;
    Node tail;

    void insertBegin(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        if (head.next == null) {
            tail = head;
        }
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
        tail = temp;
    }

    void printList() {
        Node curr = head;
        while (curr.next != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println(curr.data);
    }

    // Recursive function to print a linked list
    public static void traverse(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }


        System.out.print(head.data + " -> ");

        traverse(head.next);
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
