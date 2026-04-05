class MinStack {
    private Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = val;
        if (!stack.isEmpty()) {
            min = Math.min(min, stack.peek()[1]);
        }
        stack.push(new int[] {val, min});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
