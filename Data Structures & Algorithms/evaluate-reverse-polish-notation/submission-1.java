class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s: tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    // order matters for substraction
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first - second);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    // order matters for division
                    int sec = stack.pop();
                    int fir = stack.pop();
                    stack.push(fir / sec);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
