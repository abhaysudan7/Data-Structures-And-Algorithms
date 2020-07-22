package sorting;

import java.util.Arrays;

/**
 * (a) Sort an array of 0s, 1s, 2s.
 * (b) Three-way partitioning when multiple occurrences of a pivot may exist.
 * (c) Partitioning around a range.
 */
public class ThreeTypesOfElements {

    /**
     * func : sort_n
     * Approach: Naive Approach
     * Time: O(n)
     * Aux Space: O(n)
     *
     * @param arr int[]
     * @param n   int
     */
    static void sort_n(int[] arr, int n) {

        int[] temp = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                temp[k++] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1)
                temp[k++] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 2)
                temp[k++] = arr[i];
        }

        if (n >= 0) System.arraycopy(temp, 0, arr, 0, n);
    }

    /**
     * func : sort_e
     * Approach: Efficient Approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param n   int
     */
    static void sort_e(int[] arr, int n) {
        int lo = 0, hi = n - 1, mid = 0;
        while (mid <= hi) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, lo, mid);
                    mid++;
                    lo++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, hi);
                    hi--;
                    break;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 2, 1, 2};
        sort_n(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {0, 1, 0, 2, 1, 2};
        sort_e(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));
    }


}
