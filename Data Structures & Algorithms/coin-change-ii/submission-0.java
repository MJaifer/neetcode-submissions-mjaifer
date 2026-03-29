class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return dfs(coins, amount, 0, dp);
    }

    private int dfs(int[] coins, int amount, int i, int[][] dp) {
        if (i == coins.length || amount < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        int notPick = dfs(coins, amount, i+1, dp);
        int pick = dfs(coins, amount - coins[i], i, dp);

        return dp[i][amount] = pick + notPick;
    }
}
