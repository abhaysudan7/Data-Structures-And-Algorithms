package stack;

import java.util.Stack;

/*
 * 1544. Make The String Great
 */
public class GreatStringLC {
    public static String makeGood(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().toString().equalsIgnoreCase(c + "") && st.peek() != c) {
                st.pop();
            } else {
                st.push(c);
            }
        }

        for (char c : st) {
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s));
    }
}
