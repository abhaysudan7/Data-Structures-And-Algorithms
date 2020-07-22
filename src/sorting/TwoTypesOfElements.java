package sorting;

import java.util.Arrays;

/**
 * (a) Segregate negative and positive elements.
 * (b) Segregate even and odd elements.
 * (c) Sort a binary array.
 */
public class TwoTypesOfElements {

    /**
     * func : sort_n
     * Approach: Naive Approach
     * Time: O(n)
     * Aux Space: O(n)
     *
     * @param arr int[]
     * @param n   int[]
     */
    static void sort_n(int[] arr, int n) {
        int[] temp = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                temp[k++] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0)
                temp[k++] = arr[i];
        }

        if (n >= 0) System.arraycopy(temp, 0, arr, 0, n);
    }

    /**
     * func : sort_e1
     * Approach: Efficient Approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param n   int
     */
    static void sort_e1(int[] arr, int n) {
        int i = -1, j = n;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);
            do {
                j--;
            } while (arr[j] >= 0);
            if (i >= j) return;
            swap(arr, i, j);
        }
    }

    /**
     * func : sort_e2
     * Approach: Efficient Approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param n   int
     */
    static void sort_e2(int[] arr, int n) {
        int i = -1;
        for (int j = 0; j <= n - 1; j++) {
            if (arr[j] < 0) {
                i++;
                swap(arr, i, j);
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
        int[] arr = {13, -12, 18, -10};
        sort_n(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {13, -12, 18, -10};
        sort_e1(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {13, -12, 18, -10};
        sort_e2(arr2, arr2.length);
        System.out.println(Arrays.toString(arr2));

    }
}
