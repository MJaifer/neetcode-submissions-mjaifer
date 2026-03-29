class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robHelper(nums, 0, n-2), robHelper(nums, 1, n-1));
    }

    private int robHelper(int[] nums, int start, int end) {
        int prev1 = nums[start];
        int prev2 = 0;

        for (int i = start+1; i <= end; i++) {
            int pick = nums[i];
            if (i >= 2) {
                pick += prev2;
            }
            int notPick = prev1;
            prev2 = prev1;
            prev1 = Math.max(pick, notPick);
        }

        return prev1;
    }
}
