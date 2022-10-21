package easy.maxdepthbinarytree;

import model.TreeNode;

public class MasDepthFinderImpl implements MasDepthFinder {

    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ResultHolder resultHolder = new ResultHolder();
        getDepth(root, resultHolder, 1);
        return resultHolder.getResult();
    }

    private void getDepth(TreeNode root, ResultHolder resultHolder, int currentDepth) {
        if (resultHolder.getResult() < currentDepth) {
            resultHolder.inc();
        }
        if (root.left != null) {
            getDepth(root.left, resultHolder, currentDepth + 1);
        }
        if (root.right != null) {
            getDepth(root.right, resultHolder, currentDepth + 1);
        }
    }

    public static class ResultHolder {
        int result;

        public void inc() {
            result++;
        }

        public int getResult() {
            return result;
        }
    }
}
