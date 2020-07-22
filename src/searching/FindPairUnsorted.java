package searching;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array and number x,
 * we need to find if there is a pair in
 * the array with sum equals to x.
 */
public class FindPairUnsorted {

    /**
     * func : getPair_n
     * Approach: Naive Approach
     * Time: O(n^2)
     * Aux Space: O(1)
     *
     * @param arr
     * @param n
     * @param x
     * @return
     */
    static boolean getPair_n(int arr[], int n, int x) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == x) {
                    System.out.println("(" + arr[i] + "," + arr[j] + ")");
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * func : getPair_e
     * Approach: Efficient Approach(Hashing)
     * Time: O(n)
     * Aux Space: O(n)
     *
     * @param arr
     * @param n
     * @param x
     * @return
     */
    static boolean getPair_e(int arr[], int n, int x) {
        Set<Integer> hs = new HashSet<>();

        for (Integer i :
                arr) {
            if (!hs.contains(x - i))
                hs.add(i);
            else
                return true;
        }

        return false;
    }

    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = {3, 5, 9, 2, 8, 10, 11};
        int x = 17;
        int n = arr.length;
        System.out.println(getPair_n(arr, n, x));
        System.out.println(getPair_e(arr, n, x));
    }
}
