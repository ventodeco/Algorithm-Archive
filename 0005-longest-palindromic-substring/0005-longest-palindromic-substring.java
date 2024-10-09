class Solution {
    public String longestPalindrome(String s) {

        String result = "";
        Deque<Character> deque;
        Integer left, right;

        for (int i = 0; i < s.length(); i++) {

            // odd
            deque = new ArrayDeque();
            deque.addFirst(s.charAt(i));
            left = i - 1;
            right = i + 1;
            result = checkPalindrome(left, right, s, deque, result);

            // even
            left = i;
            right = i + 1;
            deque = new ArrayDeque();
            result = checkPalindrome(left, right, s, deque, result);
        }

        return result;
    }
    
    private String checkPalindrome(int left, int right, String s, Deque<Character> deque, String result) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }

            deque.addFirst(s.charAt(left));
            deque.addLast(s.charAt(right));
            left--;
            right++;
        }
        
        if (deque.size() > result.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character ch : deque) {
                stringBuilder.append(ch);
            }
            result = stringBuilder.toString();
        }
        
        return result;
    }
}
