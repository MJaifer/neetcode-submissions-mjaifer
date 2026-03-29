class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int lis = 1;
        for (int i = 0; i < n; i++) {
            lis = Math.max(lis, dfs(nums, i, dp));
        }
        
        return lis;
    }

    private int dfs(int[] nums, int i, int[] dp) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int lis = 1;
        // look all the elements on right of current
        // recurse if next element is greater than current
        for (int j = i+1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                lis = Math.max(lis, 1 + dfs(nums, j, dp));
            }
        }

        return dp[i] = lis;
    }
}
