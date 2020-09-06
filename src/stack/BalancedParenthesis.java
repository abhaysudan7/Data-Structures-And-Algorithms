package stack;

import java.util.Stack;

public class BalancedParenthesis {

    static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[')
                stack.push(str.charAt(i));
            else {
                if (stack.isEmpty())
                    return false;
                else if (!matching(stack.peek(), str.charAt(i)))
                    return false;
                else
                    stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private static boolean matching(char a, char b) {
        return ((a == '{' && b == '}') || (a == '(' && b == ')') || (a == '[' && b == ']'));
    }

    public static void main(String[] args) {
        String str = "[{(){}}]";
        System.out.println("Is Balanced ? " + isBalanced(str));
    }
}
