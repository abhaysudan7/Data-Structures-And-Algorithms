package linkedlist;

public class DetectNRemoveLoop {

    /**
     * func : detectNRemoveLoop
     * Approach: Efficient approach(Floyd Cycle Detection)
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param head Node
     */
    static void detectNRemoveLoop(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (slow != fast)
            return;

        slow = head;
        while (fast.next != slow.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }


    public static void main(String[] args) {
        List list = new List();
        list.insertBegin(20);
        list.insertBegin(10);
        list.insertBegin(5);
        list.insertEnd(55);
        list.insertEnd(60);
        list.insertEnd(95);

        list.tail.next = list.head.next.next.next;
        detectNRemoveLoop(list.head);

        list.printList();

    }
}
