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
    public void reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode start = dummy.next;
        ListNode prevGroup = dummy;

        while(true) {
            for(int i = 0; i < k && curr != null; i++){
                curr = curr.next;
            }

            if(curr == null) {
                break;
            }

            prevGroup.next = null;
            ListNode next = curr.next;
            curr.next = null;

            reverse(start);

            prevGroup.next = curr;
            start.next = next;

            prevGroup = start;
            curr = start;
            start = start.next;
        }

        return dummy.next;
    }
}
