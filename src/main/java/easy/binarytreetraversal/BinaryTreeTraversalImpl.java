package easy.binarytreetraversal;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversalImpl implements BinaryTreeTraversal {
    @Override
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        traverse(node.left, result);
        result.add(node.val);
        traverse(node.right, result);
    }
}
