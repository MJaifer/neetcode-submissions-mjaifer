class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];
        
        for (int i1 = 1; i1 <= l1; i1++) {
            for (int i2 = 1; i2 <= l2; i2++) {
                if (text1.charAt(i1-1) == text2.charAt(i2-1)) {
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                } else {
                    // 3 choices
                    //   1. stay on i1 of s1
                    int stayi1 = dp[i1][i2-1];
                    
                    //   2. stay on i2 of s2
                    int stayi2 = dp[i1-1][i2];
                    
                    //   3. skip both i1 and i2
                    int skip = dp[i1-1][i2-1];

                    dp[i1][i2] = Math.max(skip, Math.max(stayi1, stayi2));
                }
            }
        }
        return dp[l1][l2];
    }
}
