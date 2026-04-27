/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) { 
            return head;
        }
        Node curr = head;

        while(curr != null) {
            Node newNode = new Node(curr.val);
            Node next = curr.next;
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }

        Node dummy = new Node(-1);
        curr = head;

        while(curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node temp = dummy;
        dummy.next = head.next;
        dummy = dummy.next;
        while(curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;

            if(copy.next != null){
                dummy.next = copy.next.next;
                dummy = dummy.next;
            }
            curr = curr.next;
        }

        return temp.next;
    }
}
