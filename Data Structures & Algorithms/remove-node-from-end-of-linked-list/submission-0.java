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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // [1,2,3,4], n = 2
        // grab n-1 th node, break the link
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        // move fast by n
        // fast = 3 by end of the following loop
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // move both slow and fast until we reach the end
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow is 2 by the end of previous loop
        // remove the next node (3)
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
