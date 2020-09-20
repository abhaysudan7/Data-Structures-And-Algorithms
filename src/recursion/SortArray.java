package recursion;

import linkedlist.List;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortArray {

    static void sort(LinkedList<Integer> list) {
        if (list.size() == 1)
            return;
        int temp = list.removeLast();
        sort(list);
        insert(list, temp);
    }

    static void insert(LinkedList<Integer> list, int temp) {
        if (list.size() == 0 || list.getLast() <= temp) {
            list.addLast(temp);
            return;
        }
        int val = list.removeLast();
        insert(list, temp);
        list.addLast(val);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] arr = {1, 5, 7, 6, 2, 8};
        for (int i :
                arr) {
            list.add(i);
        }
        System.out.println(list);
        sort(list);
        System.out.println(list);
    }
}
