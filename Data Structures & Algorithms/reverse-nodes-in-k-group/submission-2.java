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
        ListNode prevTail = null;
        while (curr != null) {
            ListNode kthNode = getKthNode(curr, k);

            if (kthNode == null) {
                // we've reached the last group. no need to reverse
                if (prevTail != null) {
                    prevTail.next = curr;
                }
                break;
            }

            if (prevTail == null) {
                // first iteration
                head = kthNode;
            } else {
                prevTail.next = kthNode;
            }

            ListNode nextHead = kthNode.next;
            kthNode.next = null;

            reverse(curr);

            curr.next = nextHead;
            prevTail = curr;
            curr = nextHead;
        }
        return head;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        int i = 1;
        while (i++ < k && curr != null) {
            curr = curr.next;
        }
        return curr;
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
}
