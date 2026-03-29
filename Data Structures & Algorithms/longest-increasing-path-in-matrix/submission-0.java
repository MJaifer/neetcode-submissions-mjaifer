class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) {
                    dfs(matrix, dp, i, j);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix, int[][] dp, int i, int j) {
        int R = matrix.length;
        int C = matrix[0].length;

        int[] dr = new int[] {1, 0, -1, 0};
        int[] dc = new int[] {0, 1, 0, -1};

        if (dp[i][j] == -1) {
            dp[i][j] = 1;
        }

        for (int d = 0; d < 4; d++) {
            int adjRow = i + dr[d];
            int adjCol = j + dc[d];

            // out of bounds
            if (adjRow < 0 || adjRow == R || adjCol < 0 || adjCol == C) {
                continue;
            }

            // adj cell is having smaller or equal number => no need to visit adj cell
            if (matrix[i][j] >= matrix[adjRow][adjCol]) {
                continue;
            }

            // adjacent row is not previously visited => perform recursion
            if (dp[adjRow][adjCol] == -1) {
                dfs(matrix, dp, adjRow, adjCol);
            }
            dp[i][j] = Math.max(dp[i][j], 1 + dp[adjRow][adjCol]);
        }
    }
}
