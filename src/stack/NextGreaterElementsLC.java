package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementsLC {
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            if (i < n) {
                if (st.isEmpty()) res[i % n] = -1;
                else res[i % n] = st.peek();
            }
            st.push(nums[i % n]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
