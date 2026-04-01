class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) {
            return false;
        }

        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < l1; i++) {
            char c1 = s1.charAt(i);
            map1[c1 - 'a']++;

            char c2 = s2.charAt(i);
            map2[c2 - 'a']++;
        }

        String key = Arrays.toString(map1);

        if (key.equals(Arrays.toString(map2))) {
            return true;
        }

        // collect the characters of substring with length l1 from s2, if it matches key, we have a permutation
        int l = 0, r = l1;

        for (; r < l2; r++, l++) {
            char cR = s2.charAt(r);
            char cL = s2.charAt(l);
            map2[cL - 'a']--;
            map2[cR - 'a']++;
            if (key.equals(Arrays.toString(map2))) {
                return true;
            }    
        }

        return false;
    }
}
