class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return dfs(prices, 0, 1, dp);
    }

    private int dfs(int[] prices, int i, int canBuy, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][canBuy] != -1) {
            return dp[i][canBuy];
        }

        int profit = 0;
        if (canBuy == 1) {
            int dontBuy = dfs(prices, i+1, 1, dp);
            int buy = -prices[i] + dfs(prices, i+1, 0, dp);
            profit = Math.max(buy, dontBuy);
        } else {
            int dontSell = dfs(prices, i+1, 0, dp);

            // if we are selling, include cool down period on next possible transaction
            int sell = prices[i] + dfs(prices, i+2, 1, dp);

            profit = Math.max(sell, dontSell);
        }

        return dp[i][canBuy] = profit;
    }
}
