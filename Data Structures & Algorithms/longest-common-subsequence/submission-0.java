class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1][l2];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return dfs(text1, text2, l1-1, l2-1, dp);
    }

    private int dfs(String s1, String s2, int i1, int i2, int[][] dp) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        if (s1.charAt(i1) == s2.charAt(i2)) {
            return dp[i1][i2] = 1 + dfs(s1, s2, i1-1, i2-1, dp);
        }

        // 3 choices
        //   1. stay on i1 of s1
        int stayi1 = dfs(s1, s2, i1, i2-1, dp);
        
        //   2. stay on i2 of s2
        int stayi2 = dfs(s1, s2, i1-1, i2, dp);
        
        //   3. skip both i1 and i2
        int skip = dfs(s1, s2, i1-1, i2-1, dp);

        return dp[i1][i2] = Math.max(skip, Math.max(stayi1, stayi2));
    }
}
