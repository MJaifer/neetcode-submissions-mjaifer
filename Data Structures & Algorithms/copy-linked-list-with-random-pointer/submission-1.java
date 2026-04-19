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

        // connect (original) -> (copy) -> (next or original)
        // A --> B --> C

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // connect copy with random
        curr = head;
        while(curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // separate two lists
        Node dummy = new Node(0);
        Node copy = dummy;
        curr = head;
        while (curr != null) {
            // A --> A' --> B --> B'
            copy.next = curr.next;
            curr.next = copy.next.next;

            curr = curr.next;
            copy = copy.next;
        }

        return dummy.next;
    }
}
