package sorting;

/**
 * Intersection of two sorted arrays.
 * O/P : distinct and same elements int two sorted arrays
 */
public class IntersectionSortedArrays {

    /**
     * func : intersection_n
     * Approach: Naive Approach
     * Time: O(n*m)
     * Aux Space: O(1)
     *
     * @param a int[]
     * @param b int[]
     * @param m int
     * @param n int
     */
    static void intersection_n(int[] a, int[] b, int m, int n) {
        for (int i = 0; i < m; i++) {
            if (i > 0 && a[i - 1] == a[i])
                continue;
            for (int j = 0; j < n; j++) {
                if (j > 0 && b[j - 1] == b[j]) {
                    continue;
                }
                if (a[i] == b[j])
                    System.out.print(a[i] + " ");

            }
        }

    }

    /**
     * func: intersection_e
     * Approach: Efficient Approach(Merge Two Array Approach)
     * Time: O(m+n)
     * Aux Space: O(1)
     *
     * @param a int[]
     * @param b int[]
     * @param m int
     * @param n int
     */
    static void intersection_e(int[] a, int[] b, int m, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (i > 0 && a[i - 1] == a[i]) {
                i++;
                continue;
            }
            if (a[i] < b[j])
                i++;
            else if (a[i] > b[j])
                j++;
            else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
    }


    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] a = {3, 5, 10, 10, 10, 15, 15, 20};
        int[] b = {5, 10, 10, 15, 30};

        intersection_n(a, b, a.length, b.length);
        System.out.println();
        intersection_e(a, b, a.length, b.length);
    }
}
