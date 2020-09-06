package tree;

import java.util.Stack;

/**
 * Depth First Traversal
 * Recursion used
 */
public class Traversal {

    /**
     * func : inorder
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(h) h : height of tree
     *
     * @param root {@link Node}
     */
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    static void inorder_itr(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (true) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (stack.isEmpty())
                break;
            p = stack.pop();
            System.out.print(p.key + " ");
            p = p.right;
        }
    }


    /**
     * func : preorder
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(h) h : height of tree
     *
     * @param root {@link Node}
     */
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void preorder_itr(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (true) {
            while (p != null) {
                System.out.print(p.key + " ");
                stack.push(p);
                p = p.left;
            }

            if (stack.isEmpty())
                break;
            p = stack.pop();
            p = p.right;
        }
    }

    /**
     * func : postorder
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(h) h : height of tree
     *
     * @param root {@link Node}
     */
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
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

        System.out.println("Inorder Traversal : ");
        inorder(root);
        System.out.println();
        inorder_itr(root);

        System.out.println("\nPreorder Traversal : ");
        preorder(root);
        System.out.println();
        preorder_itr(root);

        System.out.println("\nPostorder Traversal : ");
        postorder(root);

    }
}
