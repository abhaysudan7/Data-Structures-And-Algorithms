package sorting;

import java.util.Arrays;

public class CountSort {


    /**
     * func : sort_n
     * Approach: Naive Approach
     * Time: Θ(n+k)
     * Aux Space: Θ(k)
     *
     * @param arr int[]
     * @param n   int
     * @param k   int
     */
    static void countSort(int[] arr, int n, int k) {
        int[] count = new int[k];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[index++] = i;
            }
        }
    }

    /**
     * func : countSort_g
     * Approach: General purpose approach
     * Time: Θ(n+k)
     * Aux Space: Θ(n+k)
     *
     * @param arr int[]
     * @param n   int
     * @param k   int
     */
    static void countSort_g(int[] arr, int n, int k) {
        int[] count = new int[k];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < k; i++) {
            count[i] = count[i - 1] + count[i];
        }

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        if (n >= 0) System.arraycopy(output, 0, arr, 0, n);
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] arr = {1, 4, 4, 1, 0, 1};
        int k = 5;
        countSort(arr, arr.length, k);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {5, 6, 5, 2};
        k = 7;
        countSort(arr2, arr2.length, k);
        System.out.println(Arrays.toString(arr2));
    }

}
