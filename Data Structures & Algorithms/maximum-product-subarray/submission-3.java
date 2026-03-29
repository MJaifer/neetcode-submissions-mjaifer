class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;

        int curMax = 1;
        int curMin = 1;

        for (int num: nums) {
            // possible max product
            int prodMax = curMax * num;    // this may be -ve if current numer is -ve
            
            // if num is -ve, num * curMin may be the max
            int prodMin = curMin * num;

            // update curMax and curMin
            curMax = Math.max(Math.max(prodMax, prodMin), num);
            curMin = Math.min(Math.min(prodMax, prodMin), num);

            max = Math.max(max, curMax);
        }

        return max;
    }
}
