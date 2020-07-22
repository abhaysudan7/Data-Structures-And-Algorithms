package sorting;

import java.util.Arrays;

public class CycleSort {

    /**
     * func : cycleSort
     * Approach: Efficient Approach
     * Time: O(n^2)
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param n   int
     * @return int
     */
    static int cycleSort(int[] arr, int n) {
        int writes = 0;

        for (int cs = 0; cs < n; cs++) {
            int item = arr[cs];
            int pos = cs;
            for (int i = cs + 1; i < n; i++) {
                if (arr[i] < item)
                    pos++;
            }
            // If item is already in correct position
            if (pos == cs)
                continue;

            // ignore all duplicate elements
            while (item == arr[pos])
                pos += 1;

            if (pos != cs) {
                item = swap(arr, item, pos);
                writes++;
            }
            while (pos != cs) {
                pos = cs;
                for (int i = cs + 1; i < n; i++) {
                    if (arr[i] < item)
                        pos++;
                }

                // ignore all duplicate elements
                while (item == arr[pos])
                    pos += 1;

                if (pos != cs) {
                    item = swap(arr, item, pos);
                    writes++;
                }
            }
        }
        return writes;
    }

    private static int swap(int[] arr, int item, int j) {
        int temp = item;
        item = arr[j];
        arr[j] = temp;
        return item;
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] arr = {20, 10, 40, 50, 10, 30, 20, 50};
        int writes = cycleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println("Writes : " + writes);
    }

}
