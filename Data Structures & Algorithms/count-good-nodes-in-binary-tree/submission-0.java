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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        int res = 0;
        if (node.val >= max) {
            res++;
            max = node.val;
        }

        int left = dfs(node.left, max);
        int right = dfs(node.right, max);

        return res + left + right;
    }
}
