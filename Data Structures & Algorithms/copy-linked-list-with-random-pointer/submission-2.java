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
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val); // 1' // 2'
            Node next = curr.next;
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }

        curr = head;
        while(curr != null && curr.next != null){
            Node newNode = curr.next;
            if(curr.random != null) {
                newNode.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node temp = new Node(-1);
        Node dummyCopy = temp;
        while(curr != null && curr.next != null) {
            System.out.println(curr);
            Node newNode = curr.next; // 1' // 2'
            curr.next = newNode.next; // 1 -> 2 -> 2' // 1 -> 2 -> null

            curr = curr.next; // 1 -> 2* // null
            temp.next = newNode; // node -> 1'* -> 2 -> 2' // node -> 1' ->
            temp = temp.next;
        }

        return dummyCopy.next;
    }
}
