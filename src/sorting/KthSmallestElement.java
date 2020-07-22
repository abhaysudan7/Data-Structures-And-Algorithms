package sorting;

import sorting.quicksort.PartitionArray;

import java.util.Arrays;

public class KthSmallestElement {

    /**
     * func : kthSmallestElem_n
     * Approach: Naive Approach
     * Time: O(n*log(n))
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param k   int
     * @return int
     */
    static int kthSmallestElem_n(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }


    /**
     * func : kthSmallestElem_e
     * Algorithm Name : **Quick Select**
     * Approach: Efficient Approach(Quick Sort : lomuto partition)
     * Time: O(n^2)(Worst Case) , O(n)(Average Case, when pivot is randomly selected)
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param k   int
     * @return int
     */
    static int kthSmallestElem_e(int[] arr, int n, int k) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int p = PartitionArray.lomutoPartition(arr, l, r, r);
            if (p == k - 1)
                return arr[p];
            else if (p > k - 1)
                r = p - 1;
            else
                l = p + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 8, 11, 6, 26};
        int k = 5;
        System.out.println(kthSmallestElem_n(arr, k));

        int[] arr2 = {10, 4, 5, 8, 11, 6, 26};
        System.out.println(kthSmallestElem_e(arr2, arr2.length, k));
    }

}
