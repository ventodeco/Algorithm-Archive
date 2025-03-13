class Solution {
    public String longestCommonPrefix(String[] strs) {

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String result = "";
        int cnt = 0;
        boolean stop = false;
        for (int j = 0; j < minLength; j++) {
            char ch = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (ch != strs[i].charAt(j)) {
                    stop = true;
                    break;
                } 
            }

            if (stop) {
                break;
            }
            result += ch;
        }

        return result;
    }
}