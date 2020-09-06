package tree;

import java.util.Stack;

public class ZigZagTraversal {

    static void zigZagTraversal(Node root) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Node p = stack1.pop();
                System.out.print(p.key + " ");
                if (p.left != null) stack2.push(p.left);
                if (p.right != null) stack2.push(p.right);

            }
            System.out.println();
            while (!stack2.isEmpty()) {
                Node p = stack2.pop();
                System.out.print(p.key + " ");
                if (p.right != null) stack1.push(p.right);
                if (p.left != null) stack1.push(p.left);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(6);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(11);

        zigZagTraversal(root);
    }

}
