class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int[][] dp = new int[l1+1][l2+1];
        
        // base case: if we reach end of t, we have a match
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int notPick = dp[i-1][j]; //dfs(s, t, i-1, j, dp);
                int pick = 0;
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    pick = dp[i-1][j-1]; //dfs(s, t, i-1, j-1, dp);
                }

                dp[i][j] = pick + notPick;
            }
        }

        return dp[l1][l2]; //dfs(s, t, l1-1, l2-1, dp);
    }
}
