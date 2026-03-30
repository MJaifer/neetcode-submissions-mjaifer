class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length(), l2 = t.length();

        int[] dp = new int[l2+1];
        dp[0] = 1;

        for (int i = 1; i <= l1; i++) {
            int[] temp = new int[l2+1];
            temp[0] = 1;
            for (int j = 1; j <= l2; j++) {
                // int notPick = dp[i-1][j];
                int notPick = dp[j];
                int pick = 0;
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    // pick = dp[i-1][j-1];
                    pick = dp[j-1];
                }

                temp[j] = pick + notPick;
            }
            dp = temp;
        }
        return dp[l2]; //dfs(s, t, l1-1, l2-1, dp);
    }
}
