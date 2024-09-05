class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Character temp;
        for (int i = 0; i < s.length(); i++) {

            temp = s.charAt(i);
            if (temp == '(' || temp == '[' || temp == '{') {
                stack.add(temp);
                continue;
            }

            if (! stack.isEmpty() && temp == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            
            if (! stack.isEmpty() && temp == ']' && stack.peek() == '[') {
                stack.pop();
                continue;
            }
            
            if (! stack.isEmpty() && temp == '}' && stack.peek() == '{') {
                stack.pop();
                continue;
            }
            
            return false;
        }

        return stack.isEmpty();
    }
}