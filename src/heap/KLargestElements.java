package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {

    /**
     * Time Complexity : O(n+(k*log(n)))
     * Space Complexity : O(n)
     * Naive Solution(Max heap)
     *
     * @param arr int[]
     * @param k   int
     */
    static void kLargest_n(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int value : arr) {
            pq.add(value);
        }

        System.out.println(pq);

        for (int i = 0; i < k; i++) {
            System.out.print(pq.poll() + " ");
        }
    }

    /**
     * Time Complexity : O(k+(n-k)*log(k))
     * Space Complexity : O(k)
     * Efficient Solution(Min heap)
     *
     * @param arr int[]
     * @param k   int
     */
    static void kLargest_e(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        System.out.println(pq);
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 10, 20, 8, 25, 18};
        int k = 3;
        kLargest_n(arr, k);
        System.out.println();
        kLargest_e(arr, k);
    }
}
