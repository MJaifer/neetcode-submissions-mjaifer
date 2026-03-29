class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(minCost(cost, 0, dp), minCost(cost, 1, dp));
    }

    private int minCost(int[] cost, int i, int[] dp) {
        int MAX = (int) 1e9;
        int n = cost.length;
        
        if (i > n) {
            return MAX;
        }

        if (i == n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int one = minCost(cost, i+1, dp);
        int two = minCost(cost, i+2, dp);

        return dp[i] = Math.min(one, two) + cost[i];
    }
}
