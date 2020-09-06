package stack;

import arrays.ArrayListImpl;

import java.util.Arrays;

public class StackArrayImpl {

    int maxSize = 100;
    int[] stack = new int[101];
    int top = -1;
    int size = 0;


    void push(int x) {
        if (top == maxSize)
            return;
        stack[++top] = x;
        size++;
    }

    int pop() {
        if (top == -1)
            return -1;
        size--;
        return stack[top--];
    }

    void printStack() {
        for (int i = 0; i < size; i++) {
            System.out.print(stack[i] + " ");
        }
    }


    public static void main(String[] args) {
        StackArrayImpl st = new StackArrayImpl();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        st.printStack();
        st.pop();
        System.out.println();
        st.printStack();
    }
}
