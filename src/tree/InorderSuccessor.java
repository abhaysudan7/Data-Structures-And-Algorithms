package tree;

import static tree.Traversal.inorder;

public class InorderSuccessor {

    static void inorderSuccessor(Node node, Node root) {
        if (node.right != null) {
            Node temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            System.out.println(temp.key);
        } else {
            Node s = root;
            Node p = node;
            Node store = null;
            while (p.key != s.key) {
                if (p.key <= s.key) {
                    store = s;
                    s = s.left;
                } else {
                    s = s.right;
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
        root.right.right.left = new Node(100);

        System.out.println("Inorder Traversal : ");
        inorder(root);
        System.out.println("\n" + root.right.right.left.key);
        inorderSuccessor(root.right.right.left, root);
    }
}
