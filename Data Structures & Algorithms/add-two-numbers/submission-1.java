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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int rem = 0;

        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + rem;
            int res = sum%10; // 14 -> 4
            rem = sum/10;
            tail.next = new ListNode(res);

            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 != null && l2 == null){
            while(l1 != null){
                int sum = l1.val + rem;
                int res = sum%10; // 14 -> 4
                rem = sum/10;
                tail.next = new ListNode(res);

                tail = tail.next;
                l1 = l1.next;
            }
        } else if (l2 != null && l1 == null) {
            while(l2 != null){
                int sum = l2.val + rem;
                int res = sum%10; // 14 -> 4
                rem = sum/10;
                tail.next = new ListNode(res);

                tail = tail.next;
                l2 = l2.next;
            }
        }
        
        if (rem > 0) {
            tail.next = new ListNode(rem);
        }

        return dummy.next;
    }
}
