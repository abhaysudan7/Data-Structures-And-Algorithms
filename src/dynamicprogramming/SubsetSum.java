package dynamicprogramming;

import java.util.Arrays;

public class SubsetSum {

    static boolean subsetSum(int[] arr, int n, int sum) {
        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            t[0][i] = false;
        }
        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        System.out.println(subsetSum(arr, arr.length, sum));
    }
}
