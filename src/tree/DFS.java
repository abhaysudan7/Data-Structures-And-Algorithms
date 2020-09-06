package tree;

import static tree.Traversal.inorder;

public class DFS {

    static void dfs(Node root) {
        if (root != null) {
            System.out.print(root.key+" ");
            if (root.left != null)
                dfs(root.left);
            if (root.right != null)
                dfs(root.right);
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

        System.out.println("DFS Traversal : ");
        dfs(root);
    }
}
