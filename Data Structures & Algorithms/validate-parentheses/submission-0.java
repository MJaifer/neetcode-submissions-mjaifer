class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                if (!stack.isEmpty() && stack.peek() == map.get(curr)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(curr);
            }
        }

        return stack.isEmpty();
    }
}
