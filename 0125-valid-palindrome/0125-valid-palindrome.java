class Solution {
    public boolean isPalindrome(String s) {
        
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (! isAlphaNumeric(s.charAt(left))) {
                left++;
                continue;
            }

            if (! isAlphaNumeric(s.charAt(right))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}