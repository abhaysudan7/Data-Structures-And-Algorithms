package recursion;

import java.util.Stack;

public class SortStack {

    static void sort(Stack<Integer> stack) {
        if (stack.size() == 1)
            return;
        int temp = stack.pop();
        sort(stack);
        insert(stack, temp);
    }

    static void insert(Stack<Integer> stack, int temp) {
        if (stack.size() == 0 || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }
        int val = stack.pop();
        insert(stack, temp);
        stack.push(val);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = {1, 5, 7, 6, 2, 8};
        for (int i :
                arr) {
            stack.push(i);
        }
        System.out.println(stack);
        sort(stack);
        System.out.println(stack);
    }

}
