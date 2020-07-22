package sorting;

import java.util.Arrays;

public class MeetingMaximumGuests {

    /**
     * func : maxGuests
     * Approach: Efficient Approach
     * Time: O(n*log(n))
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param dep int[]
     * @param n   int
     * @return int
     */
    static int maxGuests(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 1, j = 0, res = 1, curr = 1;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                curr++;
                i++;
            } else {
                curr--;
                j++;
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] arr = {900, 600, 700};
        int[] dep = {1000, 800, 730};

        System.out.println(maxGuests(arr, dep, arr.length));
    }

}
