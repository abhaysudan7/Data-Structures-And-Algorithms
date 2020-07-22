package searching;

public class SquareRoot {

    /**
     * func : sqrt
     * Approach: Efficient Approach(Binary Search)
     * Time: O(log(x))
     * Aux Space: O(1)
     *
     * @param x int
     * @return int
     */
    static int sqrt(int x) {
        if (x == 0)
            return 0;

        int low = 1, high = x, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid == x / mid)
                return mid;
            else if (mid > x / mid)
                high = mid - 1;
            else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        System.out.println(sqrt(2147395599));
    }

}
