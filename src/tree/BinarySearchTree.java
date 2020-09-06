package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public static void main(String[] args) {

        Node root = null;

        root = insertNode(root, 15);
        root = insertNode(root, 20);
        root = insertNode(root, 10);
        root = insertNode(root, 25);
        root = insertNode(root, 8);
        root = insertNode(root, 12);
        root = insertNode(root, 16);

        levelOrderTraversal(root);

        System.out.println(search(root, 26));
        System.out.println(findMin(root));
        System.out.println(findMax(root));
        System.out.println(findHeight(root));
        deleteNode(root, 25);
        levelOrderTraversal(root);

    }

    private static Node insertNode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        } else if (data <= root.key) {
            root.left = insertNode(root.left, data);
        } else {
            root.right = insertNode(root.right, data);
        }
        return root;
    }

    public static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            System.out.println("Tree is empty");

        else {
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node temp = queue.peek();
                System.out.print(temp.key + " ");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                queue.poll();
            }
            System.out.println("");
        }
    }

    public static boolean search(Node root, int data) {
        if (root == null)
            return false;
        if (root.key == data)
            return true;
        else if (data <= root.key)
            return search(root.left, data);
        else
            return search(root.right, data);
    }

    public static int findMin(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.left == null)
            return root.key;
        else {
            return findMin(root.left);
        }
    }

    public static Node findMinItr(Node root) {

        if (root == null)
            return root;

        while (root.left != null)
            root = root.left;

        return root;

    }

    public static int findMax(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        if (root.right == null)
            return root.key;
        else {
            return findMax(root.right);
        }
    }

    public static int findHeight(Node root) {
        if (root == null)
            return -1;
        else
            return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    public static Node deleteNode(Node root, int data) {
        if (root == null)
            return root;
        else if (data < root.key)
            root.left = deleteNode(root.left, data);
        else if (data > root.key)
            root.right = deleteNode(root.right, data);
        else {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.left == null) {
                Node temp = root;
                root = root.right;
                temp = null;
            } else if (root.right == null) {
                Node temp = root;
                root = root.left;
                temp = null;
            } else {
                Node temp = findMinItr(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
        }
        return root;
    }


}
