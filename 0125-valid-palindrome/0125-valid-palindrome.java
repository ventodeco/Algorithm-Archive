class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left <= right) {
            
            if (! isAlphanumeric(s.charAt(left))) {
                left++;
                continue;
            }
            
            if (! isAlphanumeric(s.charAt(right))) {
                right--;
                continue;
            }

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    private Boolean isAlphanumeric(Character character) {
        return (character >= '0' & character <= '9') || (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
    }
}