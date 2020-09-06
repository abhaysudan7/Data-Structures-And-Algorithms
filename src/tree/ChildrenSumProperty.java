package tree;

public class ChildrenSumProperty {

    /**
     * func : printKDist
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(h) h : height of tree
     *
     * @param root {@link Node}
     * @return boolean
     */
    static boolean isCSum(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int sum = 0;
        if (root.left != null) {
            sum += root.left.key;
        }
        if (root.right != null) {
            sum += root.right.key;
        }

        return (root.key == sum && isCSum(root.left) && isCSum(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.left = new Node(3);

        System.out.println("Is Child Sum Property satisfied? : " + isCSum(root));
    }


}
