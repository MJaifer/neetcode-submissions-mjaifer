class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length;
        int l = 0, r = len-1;

        int max = 0;
        while (l < r) {
            int height = Math.min(heights[l], heights[r]);
            int curr = (r - l) * height;
            max = Math.max(max, curr);

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
