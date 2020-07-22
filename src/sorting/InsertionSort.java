package sorting;

import java.util.Arrays;

public class InsertionSort {

    /**
     * func: iSort
     * Time: O(n^2)
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param n   int
     */
    static void iSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        int[] arr = {50, 20, 40, 60, 10, 30};
        System.out.println(Arrays.toString(arr));
        iSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
