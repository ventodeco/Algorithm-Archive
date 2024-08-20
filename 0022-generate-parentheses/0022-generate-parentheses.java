class Solution {
    
    public List<String> generateParenthesis(int n) {

        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        
        result = backtrack(0, 0, n, result, stack);

        return result;
    }
    
    private List<String> backtrack(int openN, int closeN, int n, List<String> result, Stack<String> stack) {
        
        if (openN == closeN && closeN == n) {
            String str = "";
            for (int i = 0; i < stack.size(); i++) {
                str += stack.get(i);
            }
            result.add(str);
            return result;
        }
        
        if (openN < n) {
            stack.add("(");
            result = backtrack(openN + 1, closeN, n, result, stack);
            stack.pop();
        }
        
        if (closeN < openN) {
            stack.add(")");
            result = backtrack(openN, closeN + 1, n, result, stack);
            stack.pop();
        }
        
        return result;
    }
}