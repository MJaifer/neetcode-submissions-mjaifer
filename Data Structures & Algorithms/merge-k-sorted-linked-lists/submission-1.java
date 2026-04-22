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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return divide(lists, 0, lists.length-1);
    }

    private ListNode divide(ListNode[] lists, int l, int r) {
        if (l > r) return null;

        if (l == r) {
            return lists[l];
        }

        int mid = l + (r - l) / 2;
        ListNode left = divide(lists, l, mid);
        ListNode right = divide(lists, mid+1, r);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        curr.next = left != null? left: right;
        
        return dummy.next;
    }
}
