package searching;

/**
 * Given an unsorted array and number x,
 * we need to find if there is a pair in
 * the array with sum equals to x.
 */
public class FindPairSorted {

    /**
     * func : getPair_e
     * Approach: Efficient Approach(Two Pointer)
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param arr
     * @param n
     * @param x
     * @return
     */
    static boolean getPair_e(int arr[], int n, int x) {
        int left = 0, right = n - 1;
        while (left < right) {
            System.out.println("left:" + left + ", right:" + right);
            int sum = arr[left] + arr[right];
            if (sum == x)
                return true;
            else if (sum > x)
                right--;
            else
                left++;
        }
        return false;
    }

    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = {2, 4, 8, 9, 11, 12, 20, 30};
        int x = 23;
        int n = arr.length;
        System.out.println(getPair_e(arr, n, x));
    }
}
