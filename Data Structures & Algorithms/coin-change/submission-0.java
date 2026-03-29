class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int MAX = (int) 1e9;
        int[][] dp = new int[amount+1][n];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        int numCoins = dfs(coins, amount, n-1, dp);
        return numCoins == MAX? -1: numCoins;
    }

    private int dfs(int[] coins, int amount, int i, int[][] dp) {
        int MAX = (int) 1e9;
        if (amount == 0) {
            return 0;
        } else if (amount  < 0 || i < 0) {
            return MAX;
        }

        if (dp[amount][i] != -1) {
            return dp[amount][i];
        }

        int take = 1 + dfs(coins, amount - coins[i], i, dp);
        int notTake = dfs(coins, amount, i - 1, dp);

        return dp[amount][i] = Math.min(take, notTake);
    }
}
