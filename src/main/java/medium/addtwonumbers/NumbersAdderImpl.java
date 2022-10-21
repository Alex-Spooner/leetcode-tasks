package medium.addtwonumbers;

import model.ListNode;

public class NumbersAdderImpl implements NumbersAdder {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean needToAddOne = false;
        int firstDigitSource = l1.val + l2.val;
        if (firstDigitSource > 9) {
            needToAddOne = true;
        }

        ListNode resultCurrentNode;
        ListNode result = resultCurrentNode = new ListNode(firstDigitSource % 10);

        while (l1.next != null || l2.next != null){
            ListNode currentNode = new ListNode(0);
            resultCurrentNode.next = currentNode;
            if (l1.next != null && l2.next != null) {
                l1 = l1.next;
                l2 = l2.next;
                int digitSource = l1.val + l2.val + (needToAddOne ? 1 : 0);
                needToAddOne = handleCurrentNode(currentNode, digitSource);
            } else if (l1.next != null) {
                l1 = l1.next;
                int digitSource = l1.val + (needToAddOne ? 1 : 0);
                needToAddOne = handleCurrentNode(currentNode, digitSource);
            } else {
                l2 = l2.next;
                int digitSource = l2.val + (needToAddOne ? 1 : 0);
                needToAddOne = handleCurrentNode(currentNode, digitSource);
            }
            resultCurrentNode = currentNode;
        }

        if (needToAddOne) {
            resultCurrentNode.next = new ListNode(1);
        }

        return result;
    }

    private boolean handleCurrentNode(ListNode currentNode, int digitSource) {
        boolean needToAddOne;
        needToAddOne = digitSource > 9;
        currentNode.val = digitSource % 10;
        return needToAddOne;
    }
}