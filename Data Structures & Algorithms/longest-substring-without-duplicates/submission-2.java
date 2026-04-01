class Solution {
    public int lengthOfLongestSubstring(String s) {
        // "zxyzxyz"

        // tracks character-vs-lastSeenIndex while traversing from left to right
        Map<Character, Integer> map = new HashMap<>();

        int l = 0, r = 0, maxLen = 0;

        while (r < s.length()) {
            char cR = s.charAt(r);

            // we have a duplicate
            if (map.containsKey(cR)) {
                // current window is invalid
                // shrink the window up to one index more than the last seen index of current character
                int lastSeenIndex = map.get(cR);
                l = Math.max(lastSeenIndex + 1, l);
            }
            map.put(cR, r);
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
