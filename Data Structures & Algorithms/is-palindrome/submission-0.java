class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;

        while (l < r) {
            // skip left if not alpha numeric
            while (l < r && !alphaNumeric(s.charAt(l))) {
                l++;
            }
            while (l < r && !alphaNumeric(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean alphaNumeric(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
