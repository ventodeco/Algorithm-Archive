class Solution {
    public String longestPalindrome(String s) {
        
        String result = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            // odd
            int left = i - 1;
            int right = i + 1;
            String strTemp = String.valueOf(s.charAt(i));
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                strTemp = String.valueOf(s.charAt(left)) + strTemp + String.valueOf(s.charAt(right));
                left--;
                right++;
            }

            if (result.length() < strTemp.length()) {
                result = strTemp;
            }

            // even
            if (s.charAt(i) == s.charAt(i - 1)) {
                strTemp = String.valueOf(s.charAt(i - 1)) + String.valueOf(s.charAt(i));
                left = i - 2;
                right = i + 1;

                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) != s.charAt(right)) {
                        break;
                    }
                    strTemp = String.valueOf(s.charAt(left)) + strTemp + String.valueOf(s.charAt(right));
                    left--;
                    right++;
                }

                if (result.length() < strTemp.length()) {
                    result = strTemp;
                }
            }
        }

        return result;
    }
}