class Solution {
    public int minDistance(String word1, String word2) {
        // SPACE OPTIMIZED SOLUTION
        int l1 = word1.length(), l2 = word2.length();
        int[] dp = new int[l2+1];
        
        // base case when i = 0
        for (int j = 0; j <= l2; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= l1; i++) {
            int old = dp[0];
            dp[0] = i;
            for (int j = 1; j <= l2; j++) {
                int tmp = dp[j];
                // if characters matches => move both indexes (we are offsetting the index by 1 consider index out of bound as 0)
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[j] = old;
                } else {
                    // three choices
                    // 1. insert character
                    int insert = dp[j-1];

                    // 2. delete character
                    int delete = dp[j];

                    // 3. replace character
                    int replace = old;
                    dp[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
                old = tmp;
            }
        }

        return dp[l2]; //dfs(word1, word2, l1-1, l2-1, dp);
    }
}
