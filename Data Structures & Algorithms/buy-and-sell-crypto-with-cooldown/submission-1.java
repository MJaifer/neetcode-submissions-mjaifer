class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        
        for (int i = n-1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 1) {
                    int buy = -prices[i] + dp[i+1][0];
                    int dontBuy = dp[i+1][1];
                    dp[i][canBuy] = Math.max(buy, dontBuy);
                } else {
                    int sell = prices[i];
                    if (i+2 < n) {
                        sell += dp[i+2][1];
                    }
                    int dontSell = dp[i+1][0];

                    dp[i][canBuy] = Math.max(sell, dontSell);
                }
            }
        }


        return dp[0][1];  //dfs(prices, 0, 1, dp);
    }
}
