package medium.removennode;

import model.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeRemoverTest {

    public static NodeRemover nodeRemover = new NodeRemoverImpl();

    @Test
    public void positiveTest1() {
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode result = new ListNode(1, new ListNode(4));
        assertEquals(
                result,
                nodeRemover.removeNthFromEnd(input, 2)
        );
    }

    @Test
    public void positiveTest2() {
        ListNode input = new ListNode(1);
        ListNode result = null;
        assertEquals(
                result,
                nodeRemover.removeNthFromEnd(input, 1)
        );
    }

    @Test
    public void positiveTest3() {
        ListNode input = new ListNode(1, new ListNode(2));
        ListNode result = new ListNode(1);
        assertEquals(
                result,
                nodeRemover.removeNthFromEnd(input, 1)
        );
    }

    @Test
    public void positiveTest4() {
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5))));
        ListNode result = new ListNode(1, new ListNode(4, new ListNode(5)));
        assertEquals(
                result,
                nodeRemover.removeNthFromEnd(input, 3)
        );
    }

    @Test
    public void positiveTest5() {
        ListNode input = new ListNode(1, new ListNode(2));
        ListNode result = new ListNode(2);
        assertEquals(
                result,
                nodeRemover.removeNthFromEnd(input, 2)
        );
    }
}