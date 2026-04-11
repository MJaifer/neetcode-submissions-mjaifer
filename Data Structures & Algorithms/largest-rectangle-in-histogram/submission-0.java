class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int indexBack = i;

            // the stack should be monotonically increasing
            // if current height is less, keep popping from the stack
            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                int[] pop = stack.pop();
                indexBack = pop[0];
                int area = pop[1] * (i - indexBack);
                maxArea = Math.max(area, maxArea);
            }
            stack.push(new int[] {indexBack, heights[i]});
        }

        // the left over items can be extended to the end
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int area = pop[1] * (heights.length - pop[0]);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
