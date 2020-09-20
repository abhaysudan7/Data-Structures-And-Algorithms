package recursion;

import java.util.Stack;

public class DeleteMiddleStack {

    static void deleteMiddle(Stack<Integer> stack, int k) {

        if (k == 1) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        deleteMiddle(stack, k - 1);
        stack.push(temp);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        int[] arr = {1, 5, 7, 6, 2, 8};
        for (int i :
                arr) {
            stack.push(i);
        }
        System.out.println(stack);
        deleteMiddle(stack, (stack.size()) / 2 + 1);
        System.out.println(stack);
    }

}
