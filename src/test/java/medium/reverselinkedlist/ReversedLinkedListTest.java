package medium.reverselinkedlist;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class ReversedLinkedListTest {

    ReversedLinkedList reversedLinkedList = new ReversedLinkedList();

    @Test
    public void positiveTest1(){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result = reversedLinkedList.reverseBetween(head, 2, 3);

        ListNode expectedResult = new ListNode(1, new ListNode(3, new ListNode(2)));
        Assert.assertEquals(
                expectedResult,
                result
        );
    }
}