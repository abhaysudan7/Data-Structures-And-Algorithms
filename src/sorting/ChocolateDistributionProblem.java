package sorting;

import java.util.Arrays;

/**
 * I/P :
 * 1. array of packets containing chocolates
 * 2. Number of children
 * <p>
 * Rule 1: Each child should get only 1 packet
 * Rule 2: Difference between minimum count and
 * maximum count of chocolates should
 * be minimum.
 */
public class ChocolateDistributionProblem {


    /**
     * func : minDiff
     * Approach: Efficient Approach
     * Time: O(n*log(n))
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param n   int
     * @param m   int
     */
    static int minDiff(int[] arr, int n, int m) {
        if (m > n)
            return -1;
        Arrays.sort(arr);
        int res = arr[m - 1] - arr[0];
        for (int i = 1; (i + m - 1) < n; i++) {
            res = Math.min(res, (arr[i + m - 1] - arr[i]));
        }
        return res;
    }


    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;

        System.out.println(minDiff(arr, arr.length, m));

    }

}
