class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int water = 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < len; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
            leftMax[i] = maxIndex;
        }

        max = -1;
        maxIndex = -1;
        for (int i = len-1; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
            rightMax[i] = maxIndex;
        }
        for (int i = 0; i < len; i++) {
            int curr = height[i];
            int lMax = leftMax[i];
            int rMax = rightMax[i];

            int minBoundary = Math.min(height[lMax], height[rMax]);
            int currWater = Math.max(minBoundary - curr, 0);
            water += currWater;
        }

        return water;
    }
}
