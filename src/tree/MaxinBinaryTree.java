package tree;

public class MaxinBinaryTree {

    /**
     * func : getMax
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(h) h : height of tree
     *
     * @param root {@link Node}
     * @return int
     */
    static int getMax(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        else {
            return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
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

        System.out.println("Maximum in tree is : " + getMax(root));

    }
}
