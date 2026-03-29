class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][2];

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return robHelper(nums, n-1, 1, dp);
    }

    private int robHelper(int[] nums, int i, int robCurrent, int[][] dp) {
        if (i < 0) {
            return 0;
        }

        if (dp[i][robCurrent] != -1) {
            return dp[i][robCurrent];
        }

        // two choices
        // 1. rob ith house
        int rob = 0;
        if (robCurrent == 1) {
            rob = nums[i] + robHelper(nums, i-1, 0, dp);
        }
        // 2. don't rob ith house
        int notRob = robHelper(nums, i-1, 1, dp);

        return dp[i][robCurrent] = Math.max(rob, notRob);
    }
}
