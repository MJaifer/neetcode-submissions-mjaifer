class Solution {
    public boolean isAnagram(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        if (l1 != l2) {
            return false;
        }

        int[] map = new int[26];
        for (int i = 0; i < l1; i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for (int num: map) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
