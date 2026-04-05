class MinStack {
    private Stack<Long> stack;
    private long min;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
            stack.push(0L);
        } else {
            // push difference
            stack.push(val - min);
            // update min
            if (val < min) min = val;
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();
        if (pop < 0) min = min - pop;
    }
    
    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
