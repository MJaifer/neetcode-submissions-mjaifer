class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxLen = 0, maxF = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r < s.length()) {
            char cR = s.charAt(r);
            map.put(cR, map.getOrDefault(cR, 0) + 1);
            maxF = Math.max(maxF, map.get(cR));
            

            // invalid window, shrink from left
            // window is invalid if (currentWindowLength) - (maxFrequency char in current window) is greater than k
            // currentWindowLength = (r - l + 1) 
            while (r - l + 1 - maxF - k > 0) {
                char cL = s.charAt(l);
                int leftCount = map.get(cL);
                if (leftCount == 1) {
                    map.remove(cL);
                } else {
                    map.put(cL, leftCount-1);
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
