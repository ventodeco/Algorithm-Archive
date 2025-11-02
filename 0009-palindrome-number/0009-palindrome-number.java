class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String dataStr = String.valueOf(x);
        int left = 0;
        int right = dataStr.length() - 1;

        while (left < right) {

            if (dataStr.charAt(left) != dataStr.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}