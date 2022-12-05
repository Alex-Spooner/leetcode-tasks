package medium.nodedeleter;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class NodeDeleterTest {

    private static final NodeDeleter nodeDeleter = new NodeDeleterImpl();

    @Test
    public void positiveTest1(){
        ListNode nodeToDeleteNode = new ListNode(4, new ListNode(4));
        ListNode resultLink = new ListNode(1, new ListNode(2, nodeToDeleteNode));
        ListNode expectedResult = new ListNode(1, new ListNode(2, new ListNode(4)));

        nodeDeleter.deleteNode(nodeToDeleteNode);

        Assert.assertEquals(
                expectedResult,
                resultLink
        );
    }

    @Test
    public void positiveTest2(){
        ListNode resultLink = new ListNode(2, new ListNode(4, new ListNode(4)));
        ListNode nodeToDeleteNode = new ListNode(1, resultLink);
        ListNode expectedResult = new ListNode(2, new ListNode(4, new ListNode(4)));

        nodeDeleter.deleteNode(nodeToDeleteNode);

        Assert.assertEquals(
                expectedResult,
                resultLink
        );
    }
}