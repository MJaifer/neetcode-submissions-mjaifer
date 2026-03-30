class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1][l2];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return dfs(word1, word2, l1-1, l2-1, dp);
    }

    private int dfs(String s1, String s2, int i, int j, int[][] dp) {
        // end of s1 => return remaining length of s2
        if (i < 0) {
            return j+1;
        }
        
        // end of s2 => return remaining length of s1
        if (j < 0) {
            return i+1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // if characters matches => move both indexes
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = dfs(s1, s2, i-1, j-1, dp);
        }

        // three choices
        // 1. insert character
        int insert = dfs(s1, s2, i, j-1, dp);

        // 2. delete character
        int delete = dfs(s1, s2, i-1, j, dp);

        // 3. replace character
        int replace = dfs(s1, s2, i-1, j-1, dp);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}
