class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = speed.length;

        int[][] pairs = new int[len][2];
        for (int i = 0; i < len; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for(int[] pair: pairs) {
            double time = (double) (target - pair[0]) / pair[1];
            stack.push(time);

            // keep the stack monotonic
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }
}
