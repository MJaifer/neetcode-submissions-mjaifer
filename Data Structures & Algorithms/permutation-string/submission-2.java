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

        // use a match counter to check if both arrays are equal
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (map1[i] == map2[i]) {
                matches++;
            }
        }

        if (matches == 26) {
            return true;
        }

        int l = 0, r = l1;
        for (; r < l2; r++, l++) {
            char cR = s2.charAt(r);
            int indexR = cR - 'a';
            map2[indexR]++;
            // if right index is matching, increment matches count
            if (map1[indexR] == map2[indexR]) {
                matches++;
            } else if (map1[indexR] + 1 == map2[indexR]) {
                // if right index was previously matching, decrement matches count
                matches--;
            }

            char cL = s2.charAt(l);
            int indexL = cL - 'a';
            map2[indexL]--;

            // if left index is matching, increment matches count
            if (map1[indexL] == map2[indexL]) {
                matches++;
            } else if (map1[indexL] == 1 + map2[indexL]) {
            // if left index was previously matching, decrement matches count
                matches--;
            }

            if (matches == 26) {
                return true;
            }
        }

        return false;
    }
}
