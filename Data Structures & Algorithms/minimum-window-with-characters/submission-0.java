class Solution {
    public String minWindow(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        if (l1 < l2) {
            return "";
        }

        int[] map = new int[256];
        for (int i = 0; i < l2; i++) {
            map[t.charAt(i)]++;
        }

        // objective is to keep the count of valid characters (character present in t) to match length of "t"
        // we have the count of each characters in t in "map" array
        // while iterating through "s", if a valid character is seen, reduce the count in "map"
        // we'll keep the count of valid character to 0 in map

        int minLen = Integer.MAX_VALUE;
        int validCharCount = 0;

        int l = 0, r = 0;
        int start = -1, end = 0;
        while (r < l1) {
            // if character at right is a part of "t", increment validCharCount
            char cR = s.charAt(r);
            if (map[cR] > 0) {
                validCharCount++;
            }
            map[cR]--;

            // if validCharCount is equal to length of "t", keep shrinking from left
            while (validCharCount == l2) {
                // update the current answer
                int currentWindowLen = r - l + 1;
                if (currentWindowLen < minLen) {
                    start = l;
                    end = r;
                    minLen = currentWindowLen;
                }

                // remove character at left from map
                char cL = s.charAt(l);
                map[cL]++;

                // if it crosses 0, which means it is a valid character (char present in "t")
                // invalidate the current window by reducing validCharCount
                if (map[cL] > 0) {
                    validCharCount--;
                }
                l++;
            }
            r++;
        }

        return start == -1? "": s.substring(start, end+1);
    }
}
