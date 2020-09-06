package tree;

public class NodesAtDistanceK {

    /**
     * func : printKDist
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(h) h : height of tree
     *
     * @param root {@link Node}
     * @param k    int
     */
    static void printKDist(Node root, int k) {
        if (root == null) return;
        if (k == 0) System.out.print(root.key + " ");
        else {
            printKDist(root.left, k - 1);
            printKDist(root.right, k - 1);
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

        System.out.println("Kth Dist Nodes : ");
        printKDist(root, 2);
    }

}
