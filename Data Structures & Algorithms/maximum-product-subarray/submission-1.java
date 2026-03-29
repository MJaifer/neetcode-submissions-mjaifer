class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;

        int prod = 1;

        for (int num: nums) {
            prod *= num;
            max = Math.max(prod, max);
            if (prod == 0) {
                prod = 1;
            }
        }

        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            prod *= num;
            max = Math.max(prod, max);
            if (prod == 0) {
                prod = 1;
            }
        }

        return max;
    }
}
