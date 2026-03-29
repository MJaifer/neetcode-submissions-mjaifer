class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        if ((sum & 1) != 0) {
            return false;
        }

        int n = nums.length;
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return dfs(nums, target, 0, dp);
    }

    private boolean dfs(int[] nums, int target, int i, int[][] dp) {
        if (target == 0) return true;


        if (target < 0) return false;

        if (i == nums.length) return false;

        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }

        boolean notPick = dfs(nums, target, i+1, dp);
        boolean pick = dfs(nums, target - nums[i], i+1, dp);

        if (pick || notPick) {
            dp[i][target] = 1;
        } else {
            dp[i][target] = 0;
        }

        return dp[i][target] == 1;
    }
}
