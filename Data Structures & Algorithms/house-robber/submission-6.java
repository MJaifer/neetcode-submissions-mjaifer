class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        // base case
        // rob either first or second
        int prev1 = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int rob = nums[i];
            if (i >= 2) {
                rob += prev2;
            }
            int notRob = prev1;
            prev2 = prev1;
            prev1 = Math.max(rob, notRob);
        }

        return prev1;
    }
}
