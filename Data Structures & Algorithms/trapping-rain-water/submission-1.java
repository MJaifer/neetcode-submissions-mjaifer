class Solution {
    public int trap(int[] height) {
        // one pass solution
        // O(n) time and O(1) space
        int len = height.length;
        int water = 0;

        // get the minimum of maxLeft and maxRight => this is always from either left or right
        // always perform the update on the minimum side
        //      - if lMax < rMax => perform update on the left side
        //      - else perform update on the right side

        int l = 0, r = len-1;
        int lMax = height[l];
        int rMax = height[r];

        while (l < r) {
            if (lMax < rMax) {
                l++;
                lMax = Math.max(lMax, height[l]);
                water += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                water += rMax - height[r];
            }
        }
        
        return water;
    }
}
