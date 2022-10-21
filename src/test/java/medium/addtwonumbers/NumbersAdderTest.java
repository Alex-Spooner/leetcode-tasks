package medium.addtwonumbers;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class NumbersAdderTest {

    private final NumbersAdder numbersAdder = new NumbersAdderImpl();

    @Test
    public void positiveTest() {
        ListNode first = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode second = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = new ListNode(7, new ListNode(0, new ListNode(8)));
        Assert.assertEquals(
                result,
                numbersAdder.addTwoNumbers(first, second)
        );
    }

    @Test
    public void positiveZeroTest() {
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode result = new ListNode(0);
        Assert.assertEquals(
                result,
                numbersAdder.addTwoNumbers(first, second)
        );
    }

    @Test
    public void positiveTestWithMany9() {
        ListNode first = new ListNode(9);
        ListNode second = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode result = new ListNode(8, new ListNode(0, new ListNode(0, new ListNode(1))));
        Assert.assertEquals(
                result,
                numbersAdder.addTwoNumbers(first, second)
        );
    }
}