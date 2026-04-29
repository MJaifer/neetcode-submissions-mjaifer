/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, int left, int right) {
        if (node == null) {
            return true;
        }

        // validate
        if (left >= node.val || right <= node.val) {
            return false;
        }

        boolean leftRes = dfs(node.left, left, node.val);
        if (!leftRes) {
            return false;
        }

        boolean rightRes = dfs(node.right, node.val, right);
        if (!rightRes) {
            return false;
        }

        return true;
    }

}
