class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            dp[row][0] = 1;
        }
        for (int col = 0; col < n; col++) {
            dp[0][col] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                int up = dp[row-1][col];
                int left = dp[row][col-1];
                dp[row][col] = up + left;
            }
        }

        return dp[m-1][n-1];
    }
}
