class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if (l1 + l2 != l3) {
            return false;
        }

        boolean[] dp2 = new boolean[l2+1];
        dp2[0] = true;

        // first row (match s2)
        for (int j = 1; j <= l2; j++) {
            dp2[j] = dp2[j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }

        for (int i = 1; i <= l1; i++) {
            boolean[] temp = new boolean[l2+1];
            // comes from first column (match with s1)
            temp[0] = dp2[0] && s1.charAt(i-1) == s3.charAt(i-1);
            for (int j = 1; j <= l2; j++) {
                char c3 = s3.charAt(i + j - 1);

                boolean res = false;

                if (s1.charAt(i-1) == c3) {
                    res = dp2[j];
                }

                if (!res && s2.charAt(j-1) == c3) {
                    res = temp[j-1];
                }
                temp[j] = res;
            }
            dp2 = temp;
        }

        return dp2[l2];
    }
}
