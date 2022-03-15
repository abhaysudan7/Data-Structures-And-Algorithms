package stack;

public class MinStackLC {

    private Node node;

    public void push(int val) {
        if (node == null) {
            node = new Node(val, val, null);
        } else {
            node = new Node(val, Math.min(node.min, val), node);
        }
    }

    public void pop() {
        node = node.next;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }

    class Node {
        private final int val;
        private final int min;
        private final Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStackLC minStackLC = new MinStackLC();
        minStackLC.push(-2);
        minStackLC.push(0);
        minStackLC.push(-3);
        System.out.println(minStackLC.getMin()); // return -3
        minStackLC.pop();
        System.out.println(minStackLC.top());    // return 0
        System.out.println(minStackLC.getMin()); // return -2
    }
}
