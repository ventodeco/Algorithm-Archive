class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        Integer tempNumber;
        Integer result = 0;
        for (int i = 0; i < tokens.length; i++) {
            
            try {
                tempNumber = Integer.parseInt(tokens[i]);
                stack.push(tempNumber);
            } catch (NumberFormatException e) {
                tempNumber = doMath(tokens[i], stack.pop(), stack.pop());
                stack.push(tempNumber);
            }
        }
        
        return stack.pop();
    }
    
    private Integer doMath(String operator, int number1, int number2) {
        if (operator.equals("+")) {
            return number1 + number2;
        }
        
        if (operator.equals("*")) {
            return number1 * number2;
        }
        
        if (operator.equals("/")) {
            return number2 / number1;
        }
        
        if (operator.equals("-")) {
            return number2 - number1;
        }
        
        return -1;
    }
}