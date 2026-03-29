class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if (l1 + l2 != l3) {
            return false;
        }

        Boolean[][] dp = new Boolean[l1+1][l2+1];
        return dfs(s1, s2, s3, l1, l2, l3, dp);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp) {
        // reached end of s3, check if end of both s1 and s2 is also reached
        // we are offsetting indexes by 1 for fitting it in the dp array
        if (k == 0) {
            return i == 0 && j == 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        char c3 = s3.charAt(k-1);

        boolean res = false;

        if (i > 0 && s1.charAt(i-1) == c3) {
            res = dfs(s1, s2, s3, i-1, j, k-1, dp);
        }

        if (!res && j > 0 && s2.charAt(j-1) == c3) {
            res = dfs(s1, s2, s3, i, j-1, k-1, dp);
        }
        
        return dp[i][j] = res;
    }
}
