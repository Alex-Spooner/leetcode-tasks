package medium.nodedeleter;

import model.ListNode;

public class NodeDeleterImpl implements NodeDeleter {
    @Override
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}
