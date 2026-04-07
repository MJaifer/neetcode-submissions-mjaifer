class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }

        return ans;
    }
}
