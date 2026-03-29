class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet(wordDict);
        int n = s.length();
        Boolean[] dp = new Boolean[n+1];
        return dfs(s, 0, wordSet, dp);
    }

    private boolean dfs(String s, int index, Set<String> set, Boolean[] dp) {
        if (index == s.length()) {
            return true;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        // iteratively break the string from index to s.len
        for (int i = index; i < s.length(); i++) {
            // neetcode -> n, ne, neet, neetc, neetco, neetcod, neetcode
            String subStr = s.substring(index, i+1);
            // if first part is present in the set, call dfs recursively
            if (set.contains(subStr) && dfs(s, i+1, set, dp)) {
                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }
}
