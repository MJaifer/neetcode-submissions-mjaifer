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
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        
        Node head2 = new Node(head.val);
        Node curr = head, curr2 = head2;
        map.put(curr, curr2);
        while (curr != null && curr.next != null) {
            curr2.next = new Node(curr.next.val);
            curr = curr.next;
            curr2 = curr2.next;
            map.put(curr, curr2);
        }

        curr = head; 
        curr2 = head2;
        while (curr != null) {
            curr2.random = map.get(curr.random);
            curr = curr.next;
            curr2 = curr2.next;
        }

        return head2;
    }
}
