class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        // s1 + s2 = sum
        // s1 - s2 = target
        // 2 * s2 = sum - target

        int twoS2 = sum - target;
        // problem changes to find no:of subsets where sum is equal to (sum-target)/2
        // since we are dealing with integers, (sum-target)/2 should be an integer hence, (sum-target) should be even

        if ((twoS2 & 1) != 0) {
            return 0;
        }

        int newTarget = twoS2 / 2;

        int[][] dp = new int[n][newTarget+1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return dfs(nums, newTarget, n-1, dp);
    }

    private int dfs(int[] nums, int target, int i, int[][] dp) {
        int ans = 0;
        if (target == 0) {
            ans++;
        }

        if (i == 0) {
            if (target == nums[0]) {
                return ans + 1;
            } else {
                return ans;
            }
        }

        if (dp[i][target] != -1) {
            return dp[i][target];
        }

        int notPick = dfs(nums, target, i-1, dp);
        int pick = 0;
        if (target - nums[i] >= 0) {
            pick = dfs(nums, target-nums[i], i-1, dp);
        }

        return dp[i][target] = pick + notPick;
    }
}
