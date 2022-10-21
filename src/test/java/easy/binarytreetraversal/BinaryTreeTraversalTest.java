package easy.binarytreetraversal;

import model.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BinaryTreeTraversalTest {
    private final BinaryTreeTraversal binaryTreeTraversal;

    public BinaryTreeTraversalTest(BinaryTreeTraversal binaryTreeTraversal) {
        this.binaryTreeTraversal = binaryTreeTraversal;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new BinaryTreeTraversalImpl()}
        });
    }

    @Test
    public void positiveTest() {
        TreeNode grandChildNode = new TreeNode(3);
        TreeNode childNode = new TreeNode(2, grandChildNode, null);
        TreeNode rootNode = new TreeNode(1, null, childNode);
        assertEquals(
                List.of(1, 3, 2),
                binaryTreeTraversal.inorderTraversal(rootNode)
        );
    }

    @Test
    public void positiveTest2() {
        assertEquals(
                Collections.emptyList(),
                binaryTreeTraversal.inorderTraversal(null)
        );
    }

    @Test
    public void positiveTest3() {
        TreeNode rootNode = new TreeNode(1);
        assertEquals(
                List.of(1),
                binaryTreeTraversal.inorderTraversal(rootNode)
        );
    }


}