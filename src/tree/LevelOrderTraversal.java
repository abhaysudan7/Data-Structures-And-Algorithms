package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth First Traversal
 * Queue used
 */
public class LevelOrderTraversal {

    /**
     * func : printLevel_m1
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(n)/Theta(w) w :  width of binary tree
     *
     * @param root {@link Node}
     */
    static void printLevel_m1(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q.size() > 1) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(curr.key + " ");
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    /**
     * func : printLevel_m2
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(n)/Theta(w) w :  width of binary tree
     *
     * @param root {@link Node}
     */
    static void printLevel_m2(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                System.out.print(curr.key + " ");
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
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

        System.out.println("Level Order Traversal : ");
        printLevel_m2(root);
    }

}
