package tree;

public class SizeOfTree {

    /**
     * func : getSize
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(h) h : height of tree
     *
     * @param root {@link Node}
     * @return int
     */
    static int getSize(Node root) {
        if (root == null)
            return 0;
        else {
            return 1 + getSize(root.left) + getSize(root.right);
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

        System.out.println("Size of given tree is : " + getSize(root));

    }

}
