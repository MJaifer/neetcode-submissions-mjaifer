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
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return dfs(nums2, 1, n2-2, dp);
    }

    private int dfs(int[] nums, int left, int right, int[][] dp) {
        if (left > right) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int max = Integer.MIN_VALUE;

        // split each interval at "i" and make partitions [left to i-1] and [i+1 to right]
        for (int i = left; i <= right; i++) {
            int coins = nums[left-1] * nums[i] * nums[right+1];
            coins += dfs(nums, left, i-1, dp) + dfs(nums, i+1, right, dp);
            max = Math.max(max, coins);
        }

        return dp[left][right] = max;
    }
}
