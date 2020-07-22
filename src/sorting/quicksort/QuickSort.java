package sorting.quicksort;

import java.util.Arrays;

public class QuickSort {


    /**
     * func : quickSort_l
     * Approach: Efficient Approach(Lomuto Partition/Unstable)
     * Time: O(n^2)
     * Aux Space: O(n)
     *
     * @param arr int[]
     * @param l   int
     * @param h   int
     */
    static void quickSort_l(int[] arr, int l, int h) {
        if (l < h) {
            int p = PartitionArray.lomutoPartition(arr, l, h, h);
            quickSort_l(arr, l, p - 1);
            quickSort_l(arr, p + 1, h);
        }
    }

    /**
     * func : quickSort_h
     * Approach: Efficient Approach(Hoare's Partition/Unstable)
     * Time: O(n^2)
     * Aux Space: O(n)
     *
     * @param arr int[]
     * @param l   int
     * @param h   int
     */
    static void quickSort_h(int[] arr, int l, int h) {
        if (l < h) {
            int p = PartitionArray.hoarePartition(arr, l, h);
            quickSort_h(arr, l, p);
            quickSort_h(arr, p + 1, h);
        }
    }


    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 9, 3, 10, 5};

        System.out.println("Using Lomuto Partition");
        quickSort_l(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {8, 4, 7, 9, 3, 10, 5};

        System.out.println("Using Hoare's Partition");
        quickSort_h(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
    }
}
