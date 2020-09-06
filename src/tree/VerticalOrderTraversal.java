package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    public static TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();

    public static List<List<Integer>> verticalTraversal(Node root) {

        verticalTraversal(root, 0, 0);
        List<List<Integer>> list = new ArrayList<>();
        System.out.println(map);
        for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> entry : map.entrySet()) {
            for (Map.Entry<Integer, ArrayList<Integer>> ent :
                    entry.getValue().entrySet()) {
                list.add(ent.getValue());
            }
        }
        return list;
    }


    static void verticalTraversal(Node root, int hd, int level) {
        if (root == null)
            return;

        if (!map.containsKey(hd)) {

            TreeMap<Integer, ArrayList<Integer>> a = new TreeMap<>();
            ArrayList<Integer> k = new ArrayList<>();
            k.add(root.key);
            a.put(level, k);
            map.put(hd, a);

        } else {
            TreeMap<Integer, ArrayList<Integer>> a = map.get(hd);
            if (!a.containsKey(level)) {
                ArrayList<Integer> k = new ArrayList<>();;
                k.add(root.key);
                a.put(level, k);
            } else {
                ArrayList<Integer> k = a.get(hd);
                k.add(root.key);
                a.put(level, k);
            }
            map.put(hd, a);
        }

        verticalTraversal(root.left, hd - 1, level + 1);
        verticalTraversal(root.right, hd + 1, level + 1);

    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(8);
        root.right = new Node(1);
        root.right.left = new Node(3);
        root.right.right = new Node(2);
        root.right.left.right = new Node(4);
        root.right.right.left = new Node(5);
        root.right.right.left.left = new Node(6);
        root.right.left.right.right = new Node(7);

        System.out.println(verticalTraversal(root));

    }

}
