package recursion;

import java.util.Stack;

public class ReverseStack {

    static void reverse(Stack<Integer> stack) {
        if (stack.size() == 0) {
            return;
        }
        int temp = stack.pop();
        reverse(stack);
        insert(stack, temp);
    }

    static void insert(Stack<Integer> stack, int temp) {
        if (stack.size() == 0) {
            stack.push(temp);
            return;
        }
        int t = stack.pop();
        insert(stack, temp);
        stack.push(t);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = {1, 5, 7, 6, 2, 8};
        for (int i :
                arr) {
            stack.push(i);
        }
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
