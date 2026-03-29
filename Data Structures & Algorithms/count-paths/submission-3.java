class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int row = 1; row < m; row++) {
            int[] temp = new int[n];
            temp[0] = 1;
            for (int col = 1; col < n; col++) {
                int up = dp[col];
                int left = temp[col-1];
                temp[col] = up + left;
            }
            dp = temp;
        }

        return dp[n-1];
    }
}
