class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        // base case
        // rob either first or second
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int rob = nums[i];
            if (i >= 2) {
                rob += dp[i-2];
            }
            int notRob = dp[i-1];
            dp[i] = Math.max(rob, notRob);
        }

        return dp[n-1];
    }
}
