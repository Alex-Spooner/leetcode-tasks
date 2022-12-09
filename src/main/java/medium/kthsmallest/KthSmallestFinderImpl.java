package medium.kthsmallest;

import model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class KthSmallestFinderImpl implements KthSmallestFinder {
    @Override
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> nodeList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (stack.peek() != null) {
            if (nodeList.size() == k) {
                return nodeList.get(k - 1).val;
            }
            TreeNode peek = stack.peek();
            if (peek.left != null
                    && (nodeList.size() == 0 || nodeList.get(nodeList.size() - 1).val < peek.left.val)) {
                stack.push(peek.left);
            } else if (peek.right != null
                    && (nodeList.size() == 0 || nodeList.get(nodeList.size() - 1).val < peek.right.val)) {
                nodeList.add(peek);
                stack.pop();
                stack.push(peek.right);
            } else {
                nodeList.add(peek);
                stack.pop();
            }
        }
        return nodeList.get(nodeList.size() - 1).val;
    }
}
