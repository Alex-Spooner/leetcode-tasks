package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class MinStack {

    PriorityQueue<Integer> priorityQueue;
    Deque<Integer> integerDeque;

    public MinStack() {
        priorityQueue = new PriorityQueue<>();
        integerDeque = new ArrayDeque<>();
    }

    public void push(int val) {
        priorityQueue.add(val);
        integerDeque.add(val);
    }

    public void pop() {
        Integer pop = integerDeque.removeLast();
        priorityQueue.remove(pop);
    }

    public int top() {
        Integer top = integerDeque.peekLast();
        if(top == null){
            return 0;
        }
        return top;
    }

    public int getMin() {
        Integer peek = priorityQueue.peek();
        if(peek == null){
            return 0;
        }
        return peek;
    }
}
