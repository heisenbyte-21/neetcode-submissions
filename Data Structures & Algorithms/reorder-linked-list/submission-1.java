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

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next);
        slow.next = null;
        ListNode curr = head;
        // 1 -> 2 -> 3
        // 5 -> 4
        while(curr != null && secondHalf != null) {
            ListNode next1 = curr.next; // 2 -> 3 // 3
            ListNode next2 = secondHalf.next; // 4 // null

            curr.next = secondHalf; // 1 -> 5 -> 4 // 1 -> 5 -> 2 -> 4 -> null
            secondHalf.next = next1; // 5 -> 2 -> 3 //  4 -> 3

            curr = next1;
            secondHalf = next2;
        }
    }
}
