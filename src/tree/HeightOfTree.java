package tree;

public class HeightOfTree {

    /**
     * func : getHeight
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(h) h : height of tree
     *
     * @param root {@link Node}
     * @return int
     */
    static int getHeight(Node root) {
        if (root == null) return 0;
        else {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
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

        System.out.println("Height of tree is : " + getHeight(root));
    }
}
