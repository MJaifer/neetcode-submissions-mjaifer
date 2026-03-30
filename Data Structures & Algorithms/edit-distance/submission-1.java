class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        
        // base case when j = 0
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }

        // base case when i = 0
        for (int j = 0; j <= l2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                // if characters matches => move both indexes (we are offsetting the index by 1 consider index out of bound as 0)
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]; //dfs(s1, s2, i-1, j-1, dp);
                } else {
                    // three choices
                    // 1. insert character
                    int insert = dp[i][j-1]; //dfs(s1, s2, i, j-1, dp);

                    // 2. delete character
                    int delete = dp[i-1][j]; //dfs(s1, s2, i-1, j, dp);

                    // 3. replace character
                    int replace =  dp[i-1][j-1]; //dfs(s1, s2, i-1, j-1, dp);

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[l1][l2]; //dfs(word1, word2, l1-1, l2-1, dp);
    }
}
