/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode refPointer = head;
        ListNode actualPointer = head;
        ListNode prev = head;

        for(int i = 0; i < n ; i++) {
            if(refPointer == null){
                return refPointer;
            }
            refPointer = refPointer.next;
        }

        if(refPointer == null){
            return head.next;
        }

        while(refPointer != null){
            prev = actualPointer;
            actualPointer = actualPointer.next;
            refPointer = refPointer.next;
        }

        prev.next = actualPointer.next;
        return head; 
    }
}
