package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTree {

    private static void printLeft(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();

            for (int i = 0 ; i < n ;i++){
                Node curr  = queue.poll();

                if(i == 0){
                    System.out.print(curr.key+" ");
                }

                if(curr.left != null){
                    queue.offer(curr.left);
                }

                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
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

        System.out.println("Maximum in tree is : ");
        printLeft(root);
    }


}
