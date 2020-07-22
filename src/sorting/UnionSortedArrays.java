package sorting;

import java.util.Arrays;

public class UnionSortedArrays {

    /**
     * func : union_n
     * Approach: Naive Approach
     * Time: O(m+n*log(m+n))
     * Aux Space: O(n+m)
     *
     * @param a int[]
     * @param b int[]
     * @param m int
     * @param n int
     */
    static void union_n(int[] a, int[] b, int m, int n) {
        int[] c = new int[m + n];
        for (int i = 0; i < m; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < n; i++) {
            c[m + i] = b[i];
        }
        Arrays.sort(c);

        for (int i = 0; i < m + n; i++) {
            if (i == 0 || c[i - 1] != c[i])
                System.out.print(c[i] + " ");
        }

    }

    /**
     * func: union_e
     * Approach: Efficient Approach(Merge Two Array Approach)
     * Time: O(m+n)
     * Aux Space: O(1)
     *
     * @param a int[]
     * @param b int[]
     * @param m int
     * @param n int
     */
    static void union_e(int[] a, int[] b, int m, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }
            if (a[i] < b[j]) {
                System.out.print(a[i++] + " ");
            } else if (a[i] > b[j])
                System.out.print(b[j++] + " ");
            else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
        while (i < m) {
            if (i == 0 || a[i] != a[i - 1])
                System.out.print(a[i] + " ");
            i++;
        }
        while (j < n) {
            if (j == 0 || b[j] != b[j - 1])
                System.out.print(b[j] + " ");
            j++;
        }
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] a = {3, 8, 8};
        int[] b = {2, 8, 8, 10, 15};

        union_n(a, b, a.length, b.length);
        System.out.println();
        union_e(a, b, a.length, b.length);
    }
}
