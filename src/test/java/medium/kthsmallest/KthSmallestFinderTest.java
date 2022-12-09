package medium.kthsmallest;

import model.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthSmallestFinderTest {

    private static final KthSmallestFinder smallestFinder = new KthSmallestFinderImpl();

    @Test
    public void testPositive1() {
        TreeNode grandGrandChildNodeLeftLeftLeft = new TreeNode(1, null, null);
        TreeNode grandChildNodeLeftRight = new TreeNode(4, null, null);
        TreeNode grandChildNodeLeftLeft = new TreeNode(2, grandGrandChildNodeLeftLeftLeft, null);
        TreeNode childNodeRight = new TreeNode(6, null, null);
        TreeNode childNodeLeft = new TreeNode(3, grandChildNodeLeftLeft, grandChildNodeLeftRight);
        TreeNode rootNode = new TreeNode(5, childNodeLeft, childNodeRight);
        assertEquals(3, smallestFinder.kthSmallest(rootNode, 3));
    }

    @Test
    public void testPositive2() {
        TreeNode grandChildNodeLeftRight = new TreeNode(2, null, null);
        TreeNode childNodeRight = new TreeNode(4, null, null);
        TreeNode childNodeLeft = new TreeNode(1, null, grandChildNodeLeftRight);
        TreeNode rootNode = new TreeNode(5, childNodeLeft, childNodeRight);
        assertEquals(1, smallestFinder.kthSmallest(rootNode, 1));
    }

    @Test
    public void testPositive3() {
        TreeNode rootNode = new TreeNode(5, null, null);
        assertEquals(5, smallestFinder.kthSmallest(rootNode, 1));
    }

    @Test
    public void testPositive4() {
        TreeNode childNodeRight = new TreeNode(2, null, null);
        TreeNode rootNode = new TreeNode(5, null, childNodeRight);
        assertEquals(2, smallestFinder.kthSmallest(rootNode, 2));
    }

    @Test
    public void testPositive5() {
        TreeNode childNodeLeftRight = new TreeNode(2, null, null);
        TreeNode childNodeRight = new TreeNode(4, null, null);
        TreeNode childNodeLeft = new TreeNode(1, null, childNodeLeftRight);
        TreeNode rootNode = new TreeNode(3, childNodeLeft, childNodeRight);
        assertEquals(3, smallestFinder.kthSmallest(rootNode, 3));
    }
}