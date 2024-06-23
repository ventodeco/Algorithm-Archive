class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                continue;
            }
            
            if (stack.isEmpty()) {
                return false;
            }

            if (s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
                continue;
            }
            
            if (s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
                continue;
            }
            
            if (s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            
            return false;
        }

        return stack.isEmpty();
    }
}