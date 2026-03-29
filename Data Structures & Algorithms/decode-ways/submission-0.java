class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(s, 0, dp);
    }
    private int dfs(String s, int i, int[] dp) {
        if (i == s.length()) return 1;

        if (dp[i] != -1) return dp[i];

        int curr = s.charAt(i);

        if (curr == '0') {
            return 0;
        }

        // single digit
        int single = dfs(s, i+1, dp);

        // double digit
        int dble = 0;
        if (i + 1 < s.length()) {
            String str = s.substring(i, i+2); 
            int num = Integer.valueOf(str);
            if (num <= 26) {
                dble += dfs(s, i+2, dp);
            }
        }

        return dp[i] = single + dble;
    }
}
