class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        int MAX = (int) 1e9;
        
        dp[n] = 0;

        for (int i = n-1; i >= 0; i--) {
            int one = dp[i+1];
            int two = MAX;
            if (i + 2 <= n) {
                two = dp[i+2];
            }
            dp[i] = cost[i] + Math.min(one, two);
        }

        return Math.min(dp[0], dp[1]);
    }
}
