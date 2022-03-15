package stack;

import java.util.Stack;

/*
* 682. Baseball Game
*/
public class BaseBallGameLC {
    public static int calPoints(String[] ops) {
        int res = 0;
        Stack<Integer> st = new Stack();
        for(String s : ops){
            if(s.equals("C")){
                st.pop();
            }else if(s.equals("D")){
                st.push(st.peek()*2);
            }else if(s.equals("+")){
                int last = st.pop();
                int sum = last+st.peek();
                st.push(last);
                st.push(sum);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(ops));
    }
}
