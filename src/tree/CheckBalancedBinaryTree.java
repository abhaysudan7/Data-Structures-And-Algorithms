package tree;

/**
 * Height diff btw left and right subtree should
 * not be greater than 1 for every node
 */
public class CheckBalancedBinaryTree {

    /**
     * func : chkBalanced_n
     * Approach: Naive approach
     * Time: O(n^2)
     * Aux Space: O(h) h : height of tree
     *
     * @param root {@link Node}
     * @return boolean
     */
    static boolean chkBalanced_n(Node root) {
        if (root == null) return true;
        int lh = HeightOfTree.getHeight(root.left);
        int rh = HeightOfTree.getHeight(root.right);

        return (Math.abs(lh - rh) <= 1 && chkBalanced_n(root.left) && chkBalanced_n(root.right));
    }

    /**
     * func : chkBalanced_e
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(h) h : height of tree
     *
     * @param root {@link Node}
     * @return boolean
     */
    static int chkBalanced_e(Node root) {
        if (root == null) return 0;
        int lh = chkBalanced_e(root.left);
        if (lh == -1) return -1;
        int rh = chkBalanced_e(root.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        else return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(6);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(9);
        root.left.right.left = new Node(9);
        //root.left.right.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(11);

        System.out.println("Is Binary Tree balanced ? : " + (chkBalanced_e(root) != -1));
    }

}
