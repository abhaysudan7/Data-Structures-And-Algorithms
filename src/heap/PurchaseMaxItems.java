package heap;

import java.util.PriorityQueue;

public class PurchaseMaxItems {

    /**
     * Time Complexity : O(n + log(n))
     * Space Complexity : O(n)
     *
     * @param arr int[]
     * @param sum int
     * @return int
     */
    static int maxPurchase(int[] arr, int sum) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int value : arr) {
            pq.add(value);
        }

        for (int i = 0; i < pq.size(); i++) {
            if (pq.peek() > sum) return res;
            else {
                sum = sum - pq.poll();
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 12, 5, 111, 200};
        int sum = 10;
        System.out.println(maxPurchase(arr, sum));
    }
}
