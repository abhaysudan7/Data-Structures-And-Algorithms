package searching;

import java.util.Arrays;

/**
 * Find median of two sorted arrays
 */
public class MedianSortedArrays {

    /**
     * func : findMedian_n
     * Approach: Naive Approach
     * Time: O((n+m)*log(m+n))
     * Aux Space: O(n+m)
     *
     * @param arr1 int[]
     * @param arr2 int[]
     * @return double
     */
    static double findMedian_n(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] temp = new int[n + m];

        for (int i = 0; i < n; i++) temp[i] = arr1[i];

        for (int i = n; i < m + n; i++) temp[i] = arr2[i - n];

        Arrays.sort(temp);

        if ((m + n) % 2 == 0)
            return (double) (temp[(m + n) / 2] + temp[((m + n) / 2) - 1]) / 2;
        else
            return (double) temp[(m + n) / 2];
    }

    /**
     * func : findMedian_e
     * Approach: Efficient Approach(Binary Search)
     * Time: O(log(m)) where m<=n
     * Aux Space: O(1)
     *
     * @param arr1 int[]
     * @param arr2 int[]
     * @return double
     */
    static double findMedian_e(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        if (n1 > n2)
            return findMedian_e(arr2, arr1);

        int low = 0, high = n1;
        while (low <= high) {
            int i1 = (low + high) / 2;
            int i2 = (n1 + n2 + 1) / 2 - i1;

            int min1 = (i1 == n1) ? Integer.MAX_VALUE : arr1[i1];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : arr1[i1 - 1];

            int min2 = (i2 == n2) ? Integer.MAX_VALUE : arr2[i2];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : arr2[i2 - 1];

            if (min1 >= max2 && min2 >= max1) {
                if ((n1 + n2) % 2 == 0)
                    return (double) (Math.max(max1, max2) + Math.min(min1, min2)) / 2;
                else
                    return (double) Math.max(max1, max2);
            } else if (max1 > min2)
                high = i1 - 1;
            else
                low = i1 + 1;
        }
        return -1;
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] arr1 = {2};
        int[] arr2 = {};

        System.out.println(findMedian_n(arr1, arr2));
        System.out.println(findMedian_e(arr1, arr2));

    }

}
