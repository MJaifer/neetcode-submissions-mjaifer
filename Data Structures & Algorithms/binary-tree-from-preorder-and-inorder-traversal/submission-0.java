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
    int preIndex = 0;
    Map<Integer, Integer> inIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndexMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] pre, int[] in, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        int val = pre[preIndex++];
        TreeNode root = new TreeNode(val);
        int mid = inIndexMap.get(val);

        root.left = build(pre, in, inLeft, mid-1);

        root.right = build(pre, in, mid+1, inRight);

        return root;
    }
}
