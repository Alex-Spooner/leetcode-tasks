package easy.mergesortedlist;

import model.ListNode;

public class SortedListMergerWithDummy implements SortedListMerger {
    @Override
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode();
        ListNode result = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                result.next = l2;
                result = result.next;
                l2 = l2.next;
            } else {
                result.next = l1;
                result = result.next;
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            result.next = l2;
        } else {
            result.next = l1;
        }

        return dummy.next;
    }
}
