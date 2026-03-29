class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        // iterate through each sum starting from 1 to amount
        // if index is >= 0 : dp[i] = min(dp[i], 1 + dp[i-coin])

        for (int sum = 1; sum <= amount; sum++) {
            for (int coin: coins) {
                if (sum >= coin) {
                    dp[sum] = Math.min(dp[sum], 1 + dp[sum-coin]);
                }
            }
        }

        return dp[amount] == amount+1? -1: dp[amount];
    }
}
