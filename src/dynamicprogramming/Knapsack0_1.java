package dynamicprogramming;

public class Knapsack0_1 {


    static int knapsack_recur(int[] val, int[] wt, int w, int n) {
        if(n == 0 || w == 0)
            return 0;
        if(wt[n-1] > w)
            return knapsack_recur(val,wt,w,n-1);
        else{
            return Math.max(val[n-1]+knapsack_recur(val,wt,w-wt[n-1],n-1),knapsack_recur(val,wt,w,n-1));
        }
    }


    static int knapsack_memo(int[] val, int[] wt, int[][] t, int w, int n) {
        return 0;
    }

    static int knapsack_dp(int[] val, int[] wt, int w, int n) {
        return 0;
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

        System.out.println(knapsack_recur(val, wt, w, val.length));
        //System.out.println(knapsack_memo(val, wt, t, w, val.length));
        //System.out.println(knapsack_dp(val, wt, w, val.length));

    }

}
