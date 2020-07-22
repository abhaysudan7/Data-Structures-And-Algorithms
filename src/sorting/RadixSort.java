package sorting;

import java.util.Arrays;

public class RadixSort {

    /**
     * func : radixSort
     * Approach: Efficient approach
     * Time: Θ(d*(n+b)) where b = base, d = no of times countingSort called.
     * Aux Space: Θ(n+b)
     *
     * @param arr int[]
     * @param n   int
     */
    static void radixSort(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > mx)
                mx = arr[i];
        }
        for (int exp = 1; mx / exp > 0; exp = exp * 10) {
            countingSort(arr, n, exp);
        }
    }


    /**
     * func : countingSort
     * Approach: General purpose approach
     * Time: Θ(n+b)
     * Aux Space: Θ(n+b)
     *
     * @param arr int[]
     * @param n   int
     * @param exp int
     */
    static void countingSort(int[] arr, int n, int exp) {
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] = count[i - 1] + count[i];
        }

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        if (n >= 0) System.arraycopy(output, 0, arr, 0, n);
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] arr = {319, 212, 6, 8, 100, 50};
        radixSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

}

