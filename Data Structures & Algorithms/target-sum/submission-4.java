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
        
        // base case 1: if target is 0 when i = 0
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        // base case 2: if target is equal to arr[0] when i = 0 and arr[0] != 0
        if (nums[0] != 0 && newTarget >= nums[0]) {
            dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (sum = 0; sum <= newTarget; sum++) {
                int notPick = dp[i-1][sum];
                int pick = 0;
                if (sum >= nums[i]) {
                    pick = dp[i-1][sum - nums[i]];
                }

                dp[i][sum] = notPick + pick;
            }
        }

        return dp[n-1][newTarget]; // dfs(nums, newTarget, n-1, dp);
    }
}
