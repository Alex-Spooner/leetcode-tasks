package medium.validatebinarytree;

import model.TreeNode;

public class BinarySearchTreeValidatorImpl implements BinarySearchTreeValidator {

    boolean result = true;

    @Override
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        checkNode(
                root,
                null,
                null
        );
        return result;
    }

    private void checkNode(TreeNode root, Integer globalMin, Integer globalMax) {
        int rootValue = root.val;

        TreeNode left = root.left;
        if (left != null) {
            if (left.val >= rootValue || (globalMin != null && left.val <= globalMin)) {
                result = false;
            }
            checkNode(left, globalMin, rootValue);
        }

        TreeNode right = root.right;
        if (right != null) {
            if (right.val <= rootValue || (globalMax != null && right.val >= globalMax)) {
                result = false;
            }
            checkNode(right, rootValue, globalMax);
        }
    }
}
