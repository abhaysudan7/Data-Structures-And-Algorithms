package sorting.quicksort;


import java.util.Arrays;

/**
 * Implementation of following types of partition :
 * 1.Naive Partition
 * 2.Lomuto Partition
 * 3.Hoare's Partition
 */
public class PartitionArray {

    /**
     * func : naivePartition
     * Approach: Naive Approach(Stable)
     * Time: O(n)
     * Aux Space: O(n)
     *
     * @param a int[]
     * @param l int
     * @param h int
     * @param p int
     */
    public static void naivePartition(int[] a, int l, int h, int p) {
        int[] temp = new int[h - l + 1];
        int index = 0;
        for (int i = l; i <= h; i++) {
            if (a[i] <= a[p])
                temp[index++] = a[i];
        }
        for (int i = l; i <= h; i++) {
            if (a[i] > a[p])
                temp[index++] = a[i];
        }
        for (int i = l; i <= h; i++) {
            a[i] = temp[i - l];
        }
    }

    /**
     * func : lomutoPartition
     * Approach: Efficient Approach(Best as pivot is at right position/Unstable)
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param l   int
     * @param h   int
     */
    public static int lomutoPartition(int arr[], int l, int h, int p) {
        swap(arr, p, h);
        int pivot = arr[h];
        int i = l - 1;
        for (int j = l; j <= h - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, h);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * func : hoarePartition
     * Approach: Efficient Approach(Unstable)
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param l   int
     * @param h   int
     */
    public static int hoarePartition(int arr[], int l, int h) {
        int pivot = arr[l];
        int i = l - 1, j = h + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) return j;
            swap(arr, i, j);
        }
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int a[] = {5, 13, 6, 9, 12, 11, 8};

        System.out.println("Naive Partition");
        naivePartition(a, 0, a.length - 1, 6);
        System.out.println(Arrays.toString(a));

        int b[] = {10, 80, 70, 90, 40, 50, 30};

        System.out.println("Lomuto Partition");
        lomutoPartition(b, 0, b.length - 1, 2);
        System.out.println(Arrays.toString(b));

        int c[] = {5, 3, 8, 4, 2, 7, 1, 10};

        System.out.println("Hoare's Partition");
        hoarePartition(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c));
    }
}
