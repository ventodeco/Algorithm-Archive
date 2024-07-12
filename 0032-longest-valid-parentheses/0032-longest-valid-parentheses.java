class Solution {
    public int longestValidParentheses(String s) {

        Integer low, high;
        Integer longestValid = 0;
        Integer tempCounter;
        Integer finalCalculation;
        
        Boolean openBracketExist = false;
        Boolean closeBracketExist = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openBracketExist = true;
            } else if (s.charAt(i) == ')') {
                closeBracketExist = true;
            }
        }
        
        if (!openBracketExist || !closeBracketExist) {
            return 0;
        }
        
        Stack<Character> stackChar = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            
            if (stackChar.isEmpty() && s.charAt(i) == ')') {
                continue;
            }
            
            tempCounter = 0;
            finalCalculation = 0;
            for (int j = i; j < s.length(); j++) {

                if (s.charAt(j) == '(') {
                    stackChar.add(s.charAt(j));
                } else if (s.charAt(j) == ')' && !stackChar.isEmpty() && stackChar.peek() == '(') {
                    stackChar.pop();
                    tempCounter += 2;
                    if (stackChar.isEmpty()) {
                        finalCalculation = tempCounter;
                    }
                } else {
                    break;
                }
            }
            
            if (finalCalculation > longestValid) {
                longestValid = finalCalculation;
            } 
            stackChar.clear();
        }
        
        return longestValid;
    }
}