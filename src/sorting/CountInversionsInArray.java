package sorting;

/**
 * A pair (arr[i],arr[j]) forms an
 * inversion when i < j and arr[i] > arr[j]
 */
public class CountInversionsInArray {

    /**
     * func : countInversions_n
     * Approach: Naive Approach
     * Time: O(n^2)
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param n   int
     * @return int
     */
    static int countInversions_n(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j])
                    res++;
            }
        }
        return res;
    }

    /**
     * func: countInversions_e
     * Approach: Efficient Approach(Merge Sort Approach)
     * Time: O(nlogn)
     * Aux Space: O(n)
     *
     * @param arr int[]
     * @param l   int
     * @param r   int
     * @return int
     */
    static int countInversions_e(int[] arr, int l, int r) {
        int res = 0;
        if (r > l) {
            int m = l + (r - l) / 2;
            res += countInversions_e(arr, l, m);
            res += countInversions_e(arr, m + 1, r);
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }

    /**
     * func: countAndMerge
     * Approach: Efficient Approach
     * Time: O(n)
     * Aux Space: O(n)
     *
     * @param arr int[]
     * @param l   int
     * @param m   int
     * @param r   int
     * @return int
     */
    private static int countAndMerge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + i + 1];
        }

        int i = 0, j = 0, k = l, res = 0;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                res = res + (n1 - i);
            }
        }

        while (i < n1)
            arr[k++] = left[i++];

        while (j < n2)
            arr[k++] = right[j++];
        return res;
    }


    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(countInversions_n(arr, arr.length));
        System.out.println(countInversions_e(arr, 0, arr.length - 1));

    }
}
