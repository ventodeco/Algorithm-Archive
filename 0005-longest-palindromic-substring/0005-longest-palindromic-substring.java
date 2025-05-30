class Solution {
    public String longestPalindrome(String s) {

        String palindrome = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            
            int left = i - 1;
            int right = i + 1;
            String tempVal = String.valueOf(s.charAt(i));
            while (left >= 0 && right < s.length()) {

                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }

                tempVal = s.charAt(left) + tempVal + s.charAt(right);
                left--;
                right++;
            }

            if (tempVal.length() > palindrome.length()) {
                palindrome = tempVal;
            }

            if (s.charAt(i) == s.charAt(i - 1)) {
                left = i - 2;
                right = i + 1;
                tempVal = String.valueOf(s.charAt(i - 1)) + String.valueOf(s.charAt(i));
                
                while (left >= 0 && right < s.length()) {

                    if (s.charAt(left) != s.charAt(right)) {
                        break;
                    }

                    tempVal = s.charAt(left) + tempVal + s.charAt(right);
                    left--;
                    right++;
                }
            }

            if (tempVal.length() > palindrome.length()) {
                palindrome = tempVal;
            }
        }

        return palindrome;
    }
}
