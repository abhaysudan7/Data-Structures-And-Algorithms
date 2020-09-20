package dynamicprogramming;

public class Knapsack0_1 {


    static int knapsack_recur(int[] val, int[] wt, int w, int n) {
        if (n == 0 || w == 0)
            return 0;
        if (wt[n - 1] <= w) {

            return Math.max(val[n - 1] + knapsack_recur(val, wt, w - wt[n - 1], n - 1),
                    knapsack_recur(val, wt, w, n - 1));

        } else {
            return knapsack_recur(val, wt, w, n - 1);
        }
    }


    static int knapsack_memo(int[] val, int[] wt, int[][] t, int w, int n) {
        if (n == 0 || w == 0)
            return 0;
        if (t[n][w] != -1)
            return t[n][w];

        if (wt[n - 1] <= w) {

            return t[n][w] = Math.max(val[n - 1] + knapsack_recur(val, wt, w - wt[n - 1], n - 1),
                    knapsack_recur(val, wt, w, n - 1));

        } else {
            return t[n][w] = knapsack_recur(val, wt, w, n - 1);
        }
    }

    static int knapsack_dp(int[] val, int[] wt, int w, int n) {

        int[][] k = new int[n + 1][w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0)
                    k[i][j] = 0;
                else if (wt[i - 1] <= j) {
                    k[i][j] = Math.max(val[i - 1] + k[i - 1][j - wt[i - 1]], k[i - 1][j]);
                } else {
                    k[i][j] = k[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                System.out.print(k[i][j]);
            }
            System.out.println();
        }
        return k[n][w];
    }


    public static void main(String[] args) {
        int[] val = {3, 3, 4, 5};
        int[] wt = {1, 4, 5, 7};
        int w = 7;
        int n = val.length;
        int[][] t = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                t[i][j] = -1;
            }
        }

        //System.out.println(knapsack_recur(val, wt, w, val.length));
        //System.out.println(knapsack_memo(val, wt, t, w, val.length));
        System.out.println(knapsack_dp(val, wt, w, val.length));

    }

}
