class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxLen = 0, maxF = 0;
        int[] freq = new int[26];
        while(r < s.length()) {
            char cR = s.charAt(r);
            freq[cR - 'A']++;
            maxF = Math.max(maxF, freq[cR - 'A']);
            

            // invalid window, shrink from left
            // window is invalid if (currentWindowLength) - (maxFrequency char in current window) is greater than k
            // currentWindowLength = (r - l + 1) 
            if (r - l + 1 - maxF - k > 0) {
                char cL = s.charAt(l);
                freq[cL - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
