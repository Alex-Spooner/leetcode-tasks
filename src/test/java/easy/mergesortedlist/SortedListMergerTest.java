package easy.mergesortedlist;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import model.ListNode;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SortedListMergerTest {

    private final SortedListMerger sortedListMerger;

    public SortedListMergerTest(SortedListMerger sortedListMerger) {
        this.sortedListMerger = sortedListMerger;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new SortedListMergerSimple()}, {new SortedListMergerWithDummy()}
        });
    }

    @Test
    public void positiveTest() {
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode second = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))));
        Assert.assertEquals(
                result,
                sortedListMerger.mergeTwoLists(first, second)
        );
    }

    @Test
    public void positiveTest2() {
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode second = new ListNode(-3, new ListNode(-2, new ListNode(-1)));
        ListNode result = new ListNode(-3, new ListNode(-2, new ListNode(-1, new ListNode(1, new ListNode(2, new ListNode(3))))));
        Assert.assertEquals(
                result,
                sortedListMerger.mergeTwoLists(first, second)
        );
    }

    @Test
    public void positiveTest3() {
        ListNode first = null;
        ListNode second = new ListNode(-3, new ListNode(-2, new ListNode(-1)));
        ListNode result = second;
        Assert.assertEquals(
                result,
                sortedListMerger.mergeTwoLists(first, second)
        );
    }

    @Test
    public void positiveTest4() {
        ListNode first = null;
        ListNode second = null;
        ListNode result = null;
        Assert.assertEquals(
                result,
                sortedListMerger.mergeTwoLists(first, second)
        );
    }

}