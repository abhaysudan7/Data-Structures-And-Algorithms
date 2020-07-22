package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    /**
     * func : mergeIntervals
     * Approach: Efficient Approach
     * Time: O(n*log(n))
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param n   int
     */
    static void mergeIntervals(Interval[] arr, int n) {
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
       /* for (Interval i :
                arr) {
            System.out.println(i.start + " " + i.end);
        }*/

        int res = 0;
        for (int i = 1; i < n; i++) {
            if (arr[res].end >= arr[i].start) {
                arr[res].end = Math.max(arr[res].end, arr[i].end);
                arr[res].start = Math.min(arr[res].start, arr[i].start);
            } else {
                res++;
                arr[res] = arr[i];
            }
        }
        for (int i = 0; i <= res; i++) {
            System.out.println(arr[i].start + " " + arr[i].end);
        }
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Interval[] arr = new Interval[4];
        arr[0] = new Interval(5, 10);
        arr[1] = new Interval(3, 15);
        arr[2] = new Interval(18, 30);
        arr[3] = new Interval(2, 7);
        mergeIntervals(arr, arr.length);
    }
}
