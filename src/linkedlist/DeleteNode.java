package linkedlist;

public class DeleteNode {

    /**
     * func : deleteNode
     * Approach: Efficient approach
     * Time: O(1)
     * Aux Space: O(1)
     *
     * @param node Node
     */
    static void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
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
        Node node = list.head.next.next.next.next;
        System.out.println("Delete node : " + node.data);
        deleteNode(node);
        list.printList();

    }
}
