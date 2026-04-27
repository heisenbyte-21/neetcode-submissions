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
        if(head == null){
            return head;
        }

        ListNode curr = head;

        for(int i = 0; i < n; i++){
            if(curr == null){
                return head;
            }
            curr = curr.next;
        }

        if(curr == null){
            return head.next;
        }

        ListNode prev = head;
        ListNode node = head;

        while(curr != null){
            prev = node;
            node = node.next;
            curr = curr.next;
        }

        prev.next = node.next;

        return head;
    }
}
