class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        int[] nums2 = new int[n+2];
        int n2 = nums2.length;
        nums2[0] = 1;
        nums2[n2-1] = 1;

        for (int i = 0; i < n; i++) {
            nums2[i+1] = nums[i];
        }

        int[][] dp = new int[n2][n2];

        for (int left = n2-2; left >= 1; left--) {
            for (int right = left; right <= n2-2; right++) {
                int prod = nums2[left-1] * nums2[right+1];
                for (int i = left; i <= right; i++) {
                    int coins = prod * nums2[i];
                    // coins += dfs(nums, left, i-1, dp) + dfs(nums, i+1, right, dp);
                    coins += dp[left][i-1] + dp[i+1][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[1][n2-2]; //dfs(nums2, 1, n2-2, dp);
    }
}
