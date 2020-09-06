package dynamicprogramming;

import java.util.Scanner;

/**
 * https://open.kattis.com/problems/magicalcows
 */
public class MagicalCows {

    static final int MAX_DAYS = 50;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[][] dp = new long[MAX_DAYS + 1][C + 1];

        for (int i = 0; i < N; i++) {
            int cows = sc.nextInt();
            dp[0][cows]++;
        }

        for (int day = 0; day < MAX_DAYS; day++) {
            for (int i = 1; i <= C; i++) {
                if (i <= C / 2) {
                    dp[day + 1][i * 2] += dp[day][i];
                } else {
                    dp[day + 1][i] += dp[day][i] * 2;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int day = sc.nextInt();
            System.out.println(query(dp, day));
        }
    }

    private static long query(long[][] dp, int day) {
        long farms = 0;
        long[] frequencies = dp[day];
        for (long frequency : frequencies) {
            farms += frequency;
        }
        return farms;
    }
}
