package searching;

public class PeakElement {

    /**
     * func : getPeakEle_n
     * Approach: Naive Approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param arr
     * @return
     */
    static int getPeakEle_n(int arr[]) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        if (arr[0] > arr[1])
            return arr[0];
        if (arr[n - 1] > arr[n - 1])
            return arr[n - 1];
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
                return arr[i];
        }
        return -1;
    }

    /**
     * func: getPeakEle_e
     * Approach: Efficient Approach
     * Time: O(log n)
     * Aux Space: O(1)
     *
     * @param arr
     * @return
     */
    static int getPeakEle_e(int arr[]) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
                return arr[mid];
            if (mid > 0 && arr[mid - 1] >= arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }


    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = {10, 20, 15, 5, 23, 90, 67};
        System.out.println(getPeakEle_n(arr));
        System.out.println(getPeakEle_e(arr));
    }


}
