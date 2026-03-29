class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int sum = 1; sum <= amount; sum++) {
                int notPick = 0;
                if (i > 0) {
                    notPick = dp[i-1][sum];
                }
                int pick = 0;
                if (sum - coins[i] >= 0) {
                    pick = dp[i][sum-coins[i]];
                }
                dp[i][sum] = pick + notPick;
            }
        }

        return dp[n-1][amount];// dfs(coins, amount, n-1, dp);
    }
}
