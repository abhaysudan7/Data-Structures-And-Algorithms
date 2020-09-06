package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.key + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
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
        bfs(root);
    }
}
