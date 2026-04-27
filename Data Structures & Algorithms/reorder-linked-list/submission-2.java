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

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        next = reverse(next);

        slow = head;
        while(next != null){
            ListNode temp1 = slow.next;
            ListNode temp2 = next.next;

            slow.next = next;
            next.next = temp1;

            next = temp2;
            slow = temp1;
        }
    }
}
