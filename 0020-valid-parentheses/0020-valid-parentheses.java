class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.add(s.charAt(i));
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == '[' && s.charAt(i) == ']') {
                stack.pop();
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == '{' && s.charAt(i) == '}') {
                stack.pop();
                continue;
            }

            return false;
        }

        return stack.isEmpty();
    }
}