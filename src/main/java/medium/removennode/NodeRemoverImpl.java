package medium.removennode;

import model.ListNode;

import java.util.HashMap;
import java.util.Map;

public class NodeRemoverImpl implements NodeRemover {
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        Map<Integer, ListNode> nodeLinks = new HashMap<>();
        ListNode iterator = head;
        int index = 1;
        while (iterator != null) {
            nodeLinks.put(index, iterator);
            index++;
            iterator = iterator.next;
        }

        int nodeNumber = index - 1;

        if (nodeNumber < n) {
            return null;
        }

        if (n == 1) {
            if (nodeNumber == 1) {
                return null;
            } else {
                nodeLinks.get(nodeNumber - 1).next = null;
                return head;
            }
        } else if (n == nodeNumber) {
            return nodeLinks.get(2);
        } else {
            ListNode nodeBeforeDeleted = nodeLinks.get(nodeNumber - n);
            ListNode afterDeleted = nodeLinks.get(nodeNumber - n + 2);
            nodeBeforeDeleted.next = afterDeleted;
            return head;
        }
    }
}
