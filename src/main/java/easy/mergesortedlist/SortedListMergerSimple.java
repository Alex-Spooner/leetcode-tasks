package easy.mergesortedlist;

public class SortedListMergerSimple implements SortedListMerger {
    @Override
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode result;
        if (l1.val > l2.val) {
            result = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            result = new ListNode(l1.val);
            l1 = l1.next;
        }

        ListNode resultCursor = result;

        do {
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    resultCursor.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    resultCursor.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
            } else if (l1 == null) {
                resultCursor.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                resultCursor.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            resultCursor = resultCursor.next;
        }
        while (l1 != null || l2 != null);

        return result;
    }
}
