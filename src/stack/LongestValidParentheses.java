package stack;

import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int maxCount = 0;
        int count = 0;
        Stack<Character> st = new Stack();
        for(char c:s.toCharArray()){
            if(c == '(')
                st.push(')');
            else{
               if(!st.isEmpty()){
                   if(st.pop() == c){
                       count += 2;
                   }else{
                       maxCount = Math.max(maxCount,count);
                       count = 1;
                   }
               }
            }
        }
        return Math.max(maxCount,count);
    }

    public static void main(String[] args) {
        String s = "()(()";
        System.out.print(longestValidParentheses(s));
    }
}
