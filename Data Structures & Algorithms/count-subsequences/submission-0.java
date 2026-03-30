class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int[][] dp = new int[l1][l2];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return dfs(s, t, l1-1, l2-1, dp);
    }

    private int dfs(String s, String t, int i, int j, int[][] dp) {
        if (j < 0) {
            return 1;
        }

        if (i < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int notPick = dfs(s, t, i-1, j, dp);
        int pick = 0;
        if (s.charAt(i) == t.charAt(j)) {
            pick = dfs(s, t, i-1, j-1, dp);
        }

        return dp[i][j] = pick + notPick;
    }
}
