package draft;

import model.TreeNode;

import java.util.*;

public class Test1 {

    PriorityQueue<Integer> priorityQueue = (PriorityQueue<Integer>) new PriorityQueue<>(Comparator.naturalOrder().reversed());
    Deque<Integer> integerDeque = new ArrayDeque<>();


    public void push(int val) {
        priorityQueue.add(val);
        integerDeque.add(val);
    }

    public void pop() {
        Integer pop = integerDeque.removeFirst();
        integerDeque.remove(pop);
    }

    public int top() {
        Integer top = integerDeque.pollFirst();
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
        integerDeque.remove(peek);
        return peek;
    }

    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(deque.size()!= 0){
            TreeNode current = deque.pollFirst();
            if(current.left != null){
                deque.addLast(current.left);
            }
            if(current.right != null){
                deque.addLast(current.right);
            }
            TreeNode buffer = current.left;
            current.left = current.right;
            current.right = buffer;
        }
        return root;
    }

}
