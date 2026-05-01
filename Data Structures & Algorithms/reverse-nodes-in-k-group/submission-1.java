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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        ListNode prevLast = null;

        while (curr != null) {
            // get the kth node
            ListNode kthNode = getKthNode(curr, k);

            // if kth node is null, we've reached the end group
            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = curr;
                    break;
                }
            }

            // grab the next node of kthNode
            ListNode nextNode = kthNode.next;
            
            // break the kthNode and next group
            kthNode.next = null;

            // reverse from curr to kth Node
            reverse(curr);

            if (prevLast == null) {
                // first iteration
                head = kthNode;
            } else {
                // connect prev group's last node with kthNode (as kthNode will be head of curr group)
                prevLast.next = kthNode;
            }

            // update prevLast for next iteration
            prevLast = curr;

            // update curr node to next node (as we've splited the linked list from kth node and its next node)
            curr = nextNode;
        }
        return head;
    }

    private void reverse(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    private ListNode getKthNode(ListNode curr, int k) {
        int i = 1;
        while (i < k && curr != null) {
            curr = curr.next;
            i++;
        }
        return curr;
    }
}
