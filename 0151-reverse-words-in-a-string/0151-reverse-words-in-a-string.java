class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.trim().split(" ");

        String res = "";
        for (int i = strArr.length - 1; i >= 0; i--) {
            String trimmed = strArr[i].trim();
            res += trimmed;
            if (i != 0 && trimmed != "") {
                res += " ";
            }
        }

        return res;
    }
}