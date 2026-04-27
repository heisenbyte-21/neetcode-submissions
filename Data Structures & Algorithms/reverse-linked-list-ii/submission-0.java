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

    public ListNode reverseBetween(ListNode head, int lef, int rig) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode left = dummy;

        for(int i = 0; i < lef; i++){
            leftPrev = left;
            left = left.next;
        }

        ListNode right = dummy;
        for(int i = 0; i < rig; i++){
            right = right.next;
        }

        ListNode next = right.next;
        right.next = null; //dummy -> 1 -> 2 -> 3 -> null
        leftPrev.next = null; // 1 -> 2 -> 3 -> null
        ListNode rev = reverse(left);
        leftPrev.next = rev;
        left.next = next;

        return dummy.next;
    }
}