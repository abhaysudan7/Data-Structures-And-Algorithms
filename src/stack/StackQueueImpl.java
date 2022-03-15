package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueueImpl {

    private Queue<Integer> stack;
    private Queue<Integer> q;


    public StackQueueImpl() {
        stack = new LinkedList<>();
        q = new LinkedList<>();
    }

    /*
     * Using two queues
     */
    public void push(int x) {
        q.offer(x);
        while (!stack.isEmpty()) {
            q.offer(stack.poll());
        }
        Queue<Integer> temp = stack;
        stack = q;
        q = temp;
    }

    /*
     * Using single queue
     */
//    public void push(int x) {
//        stack.offer(x);
//        for(int i = 0 ; i < stack.size()-1; i++){
//            int front = stack.poll();
//            stack.offer(front);
//        }
//    }

    public int pop() {
        return stack.poll();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackQueueImpl myStack = new StackQueueImpl();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}
