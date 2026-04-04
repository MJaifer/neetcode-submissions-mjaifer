class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet();
        for(int num: nums) {
            set.add(num);
        }

        int longestStreak = 0;
        
        for (int num: nums) {

            if (set.contains(num-1)) continue;
            int currStreak = 0;
            while (set.contains(num + currStreak)) {
                currStreak++;
            }
            longestStreak = Math.max(longestStreak, currStreak);
        }

        return longestStreak;
    }
}
