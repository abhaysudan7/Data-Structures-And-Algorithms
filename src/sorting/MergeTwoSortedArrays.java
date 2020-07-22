package sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {


    /**
     * func : merge_n
     * Approach: Naive Approach
     * Time: O((m+n)*log(m+n))
     * Aux Space: O(1)
     *
     * @param a int[]
     * @param b int[]
     */
    static void merge_n(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] temp = new int[m + n];

        for (int i = 0; i < m; i++) {
            temp[i] = a[i];
        }
        for (int i = 0; i < n; i++) {
            temp[m + i] = b[i];
        }

        Arrays.sort(temp);

        for (int x :
                temp) {
            System.out.print(x + " ");
        }
    }

    /**
     * func: merge_e
     * Approach: Efficient Approach
     * Time: O(m+n)
     * Aux Space: O(1)
     *
     * @param a int[]
     * @param b int[]
     */
    static void merge_e(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;

        int i = 0, j = 0;

        while (i < m && j < n) {
            if (a[i] < b[j])
                System.out.print(a[i++] + " ");
            else
                System.out.print(b[j++] + " ");
        }

        while (i < m)
            System.out.print(a[i++] + " ");

        while (j < n)
            System.out.print(b[j++] + " ");
    }

    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] a = {10, 15, 20, 40};
        int[] b = {5, 6, 6, 10, 15};

        merge_n(a, b);
        System.out.println();
        merge_e(a, b);
    }
}
