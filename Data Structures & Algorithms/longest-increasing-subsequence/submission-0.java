class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return dfs(nums, 0, -1, dp);
    }

    private int dfs(int[] nums, int i, int prev, int[][] dp) {
        if (i == nums.length) {
            return 0;
        }

        // offset by 1 index
        if (dp[i][prev+1] != -1) {
            return dp[i][prev+1];
        }

        int notPick = dfs(nums, i+1, prev, dp);

        int pick = 0;
        if (prev == -1 || nums[prev] < nums[i]) {
            pick = 1 + dfs(nums, i+1, i, dp);
        }

        return dp[i][prev+1] = Math.max(pick, notPick);
    }
}
