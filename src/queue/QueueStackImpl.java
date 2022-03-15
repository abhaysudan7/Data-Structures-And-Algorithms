package queue;

import java.util.Stack;

public class QueueStackImpl {

    Stack<Integer> queue;
    Stack<Integer> queue2;


    public QueueStackImpl() {
        queue = new Stack<>();
        queue2 = new Stack<>();
    }

    public void push(int x) {
        while (!queue.isEmpty()) {
            queue2.push(queue.pop());
        }
        queue.push(x);
        while (!queue2.isEmpty()) {
            queue.push(queue2.pop());
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        QueueStackImpl myQueue = new QueueStackImpl();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
