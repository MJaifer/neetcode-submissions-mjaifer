class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);
        return robHelper(nums, n-1, dp);
    }

    private int robHelper(int[] nums, int i, int[] dp) {
        if (i < 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // two choices
        // 1. rob ith house
        int rob = nums[i] + robHelper(nums, i-2, dp);
        // 2. don't rob ith house
        int notRob = robHelper(nums, i-1, dp);

        return dp[i] = Math.max(rob, notRob);
    }
}
