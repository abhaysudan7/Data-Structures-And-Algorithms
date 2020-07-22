package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {


    /**
     * func : bucketSort
     * Approach: Efficient approach
     * Time: Θ(d*(n+b))
     * Aux Space: Θ(n+b)
     *
     * @param arr int[]
     * @param k   int
     */
    static void bucketSort(int[] arr, int k) {
        int n = arr.length;
        int max_val = arr[0];
        for (int value : arr) {
            max_val = Math.max(value, max_val);
        }

        max_val++;

        ArrayList<ArrayList<Integer>> bkt = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            bkt.add(new ArrayList<Integer>());
        }

        for (int value : arr) {
            int bi = (k * value) / max_val;
            bkt.get(bi).add(value);
        }

        for (ArrayList<Integer> al : bkt) {
            Collections.sort(al);
        }

        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < bkt.get(i).size(); j++) {
                arr[index++] = bkt.get(i).get(j);
            }
        }
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] arr = {30, 40, 10, 80, 5, 12, 70};
        int k = 4;
        bucketSort(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
