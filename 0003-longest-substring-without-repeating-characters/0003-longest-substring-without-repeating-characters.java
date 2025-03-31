class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            boolean isValid = true;
            Set<Character> set = new HashSet<>();
            int tempResult = 0;

            while (isValid && right < s.length()) {

                if (set.contains(s.charAt(right))) {
                    isValid = false;
                    continue;
                }

                tempResult += 1;
                set.add(s.charAt(right));
                right++;
            }

            if (tempResult > result) {
                result = tempResult;
            }

            set.clear();
        }

        return result;
    }
}