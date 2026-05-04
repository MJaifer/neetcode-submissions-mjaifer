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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append('n').append(',');
            return;
        }

        sb.append(node.val).append(',');
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    private int index;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        if (data == "") {
            return null;
        }

        String[] nodeStrs = data.split(",");
        TreeNode root = dfs(nodeStrs);
        return root;
    }

    private TreeNode dfs(String[] nodeStrs) {
        if (nodeStrs[index].equals("n")) {
            index++;
            return null;
        }

        int val = Integer.valueOf(nodeStrs[index++]);
        TreeNode node = new TreeNode(val);
        node.left = dfs(nodeStrs);
        node.right = dfs(nodeStrs);

        return node;
    }
}
