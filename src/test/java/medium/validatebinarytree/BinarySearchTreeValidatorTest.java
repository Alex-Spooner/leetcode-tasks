package medium.validatebinarytree;

import model.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeValidatorTest {

    BinarySearchTreeValidator binarySearchTreeValidator = new BinarySearchTreeValidatorImpl();

    @Test
    public void positiveTest1() {
        TreeNode childNodeLeft = new TreeNode(1, null, null);
        TreeNode childNodeRight = new TreeNode(3, null, null);
        TreeNode rootNode = new TreeNode(2, childNodeLeft, childNodeRight);
        assertTrue(binarySearchTreeValidator.isValidBST(rootNode));
    }

    @Test
    public void positiveTest2() {
        TreeNode childNodeRight = new TreeNode(2147483647, null, null);
        TreeNode rootNode = new TreeNode(-2147483648, null, childNodeRight);
        assertTrue(binarySearchTreeValidator.isValidBST(rootNode));
    }

    @Test
    public void negativeTest1() {
        TreeNode grandChildNodeLeft = new TreeNode(3, null, null);
        TreeNode grandChildNodeRight = new TreeNode(6, null, null);
        TreeNode childNodeLeft = new TreeNode(1, null, null);
        TreeNode childNodeRight = new TreeNode(4, grandChildNodeLeft, grandChildNodeRight);
        TreeNode rootNode = new TreeNode(5, childNodeLeft, childNodeRight);
        assertFalse(binarySearchTreeValidator.isValidBST(rootNode));
    }

    @Test
    public void negativeTest2() {
        TreeNode grandGrandChildNodeLeftRightRight = new TreeNode(3, null, null);
        TreeNode grandChildNodeLeftRight = new TreeNode(2, null, grandGrandChildNodeLeftRightRight);
        TreeNode grandChildNodeLeftLeft = new TreeNode(0, null, null);
        TreeNode grandChildNodeRightRight = new TreeNode(6, null, null);
        TreeNode grandChildNodeRightLeft = new TreeNode(4, null, null);
        TreeNode childNodeRight = new TreeNode(5, grandChildNodeRightLeft, grandChildNodeRightRight);
        TreeNode childNodeLeft = new TreeNode(1, grandChildNodeLeftLeft, grandChildNodeLeftRight);
        TreeNode rootNode = new TreeNode(3, childNodeLeft, childNodeRight);
        assertFalse(binarySearchTreeValidator.isValidBST(rootNode));
    }
}