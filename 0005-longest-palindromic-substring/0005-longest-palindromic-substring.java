class Solution {
    public String longestPalindrome(String s) {

        String result = "";
        Deque<Character> deque;
        StringBuilder stringBuilder;
        Integer left, right;

        for (int i = 0; i < s.length(); i++) {

            // odd
            deque = new ArrayDeque();
            deque.addFirst(s.charAt(i));
            left = i - 1;
            right = i + 1;
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
                stringBuilder = new StringBuilder();
                for (Character ch : deque) {
                    stringBuilder.append(ch);
                }
                result = stringBuilder.toString();
            }

            // even
            left = i;
            right = i + 1;
            deque = new ArrayDeque();
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
                stringBuilder = new StringBuilder();
                for (Character ch : deque) {
                    stringBuilder.append(ch);
                }
                result = stringBuilder.toString();
            }
        }

        return result;
    }
}
