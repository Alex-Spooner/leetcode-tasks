package medium.reverselinkedlist;

import model.ListNode;

public class ReversedLinkedList {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode result = head;

        ListNode current = head;
        ListNode previous = null;

        ListNode firstLeftNonReversed = null;
        ListNode firstLeftReversed = null;

        for(int i = 1; i <= right + 1; i++){
            if(current == null){
                break;
            }

            if(i == (left - 1)){
                firstLeftNonReversed = current;
            }
            if(i == right){
                if(firstLeftNonReversed != null){
                    firstLeftNonReversed.next = current;
                }
                if(left == 1){
                    result = current;
                }
            }

            if(i == left){
                firstLeftReversed = current;
            }
            if(i == (right + 1)){
                if(firstLeftReversed != null){
                    firstLeftReversed.next = current;
                }
            }

            ListNode next = current.next;
            if (i >= left && i <= right) {
                if (i == left) {
                    current.next = null;
                } else {
                    current.next = previous;
                }
            }

            previous = current;
            current = next;
        }

        return result;
    }
}
