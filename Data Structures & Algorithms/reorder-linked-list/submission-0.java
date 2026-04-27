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
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next);
        slow.next = null;
        ListNode curr = head;

        while(curr != null && secondHalf != null) {
            ListNode next1 = curr.next;
            ListNode next2 = secondHalf.next;

            curr.next = secondHalf;
            secondHalf.next = next1;

            curr = next1;
            secondHalf = next2;
        }
    }
}
