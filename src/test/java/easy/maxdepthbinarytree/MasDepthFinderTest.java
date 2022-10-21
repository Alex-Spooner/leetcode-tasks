package easy.maxdepthbinarytree;

import model.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MasDepthFinderTest {

    public static final MasDepthFinder maxDepthFinder = new MasDepthFinderImpl();

    @Test
    public void positiveTest() {
        TreeNode grandGrandChildNode = new TreeNode(3);
        TreeNode grandChildNode = new TreeNode(3, null, grandGrandChildNode);
        TreeNode childNode = new TreeNode(2, grandChildNode, null);
        TreeNode rootNode = new TreeNode(1, null, childNode);
        assertEquals(
                4,
                maxDepthFinder.maxDepth(rootNode)
        );
    }

    @Test
    public void positiveTestWithZeroDepth() {
        assertEquals(
                0,
                maxDepthFinder.maxDepth(null)
        );
    }
}