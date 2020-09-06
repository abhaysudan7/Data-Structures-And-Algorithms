package tree;

import static tree.Traversal.inorder;

public class InorderPredecessor {

    static void inorderPredecessor(Node node, Node root) {
        if (node.left != null) {
            Node temp = node.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            System.out.println(temp.key);
        } else {
            Node s = root;
            Node p = node;
            Node store = null;
            while (p.key != s.key) {
                if (p.key > s.key) {
                    store = s;
                    s = s.right;
                } else {
                    s = s.left;
                }
            }
            System.out.println(store != null ? store.key : "Not found");
        }
    }


    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(90);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(80);
        root.right.right = new Node(110);

        System.out.println("Inorder Traversal : ");
        inorder(root);
        System.out.println("\n" + root.right.right.key);
        inorderPredecessor(root.right.right, root);
    }
}
