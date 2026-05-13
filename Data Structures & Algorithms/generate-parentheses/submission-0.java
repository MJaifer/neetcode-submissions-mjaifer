class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, res, new StringBuilder());
        return res;
    }

    private void dfs(int n, int open, int close, List<String> res, StringBuilder curr) {
        if (open == close && open == n) {
            res.add(curr.toString());
            return;
        }

        // add open '('
        if (open < n) {
            curr.append('(');
            dfs(n, open+1, close, res, curr);
            curr.deleteCharAt(curr.length()-1);
        }

        // add close ')'
        // only if close is less than open => we only want valid paths
        if (close < open) {
            curr.append(')');
            dfs(n, open, close+1, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
