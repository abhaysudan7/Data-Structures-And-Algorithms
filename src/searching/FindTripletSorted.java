package searching;

/**
 * Given an unsorted array and number x,
 * we need to find if there is a triplet in
 * the array with sum equals to x.
 */
public class FindTripletSorted {


    /**
     * func : getTriplet_e
     * Approach: Naive Approach
     * Time: O(n^3)
     * Aux Space: O(1)
     *
     * @param arr
     * @param n
     * @param x
     * @return
     */
    static boolean getTriplet_n(int arr[], int n, int x) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == x) {
                        System.out.println("(" + arr[i] + "," + arr[j] + "," + arr[k] + ")");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * func : getTriplet_e
     * Approach: Efficient Approach(Two Pointer)
     * Time: O(n^2)
     * Aux Space: O(1)
     *
     * @param arr
     * @param n
     * @param x
     * @return
     */
    static boolean getTriplet_e(int arr[], int n, int x) {
        for (int i = 0; i < n; i++) {
            if (isPair(arr, i + 1, n - 1, x - arr[i]))
                return true;
        }
        return false;
    }

    /**
     * func : getPair_e
     * Approach: Efficient Approach(Two Pointer)
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param arr
     * @param left
     * @param right
     * @param x
     * @return
     */
    static boolean isPair(int arr[], int left, int right, int x) {
        while (left < right) {
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
        int arr[] = {2, 4, 8, 9, 20, 40};
        int x = 32;
        int n = arr.length;
        System.out.println(getTriplet_n(arr, n, x));
        System.out.println(getTriplet_e(arr, n, x));
    }
}
