class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int itNeedle = 0;
        for (int i = 0; i < haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(itNeedle)) {
                boolean isValid = true;
                int it = i;
                // 0 - 2
                // 1 - 3
                // 
                while (itNeedle < needle.length() && it < haystack.length()) {
                    if (haystack.charAt(it) != needle.charAt(itNeedle)) {
                        isValid = false;
                        break;
                    }

                    it++;
                    itNeedle++;
                }

                if (isValid && itNeedle == needle.length()) {
                    return i;
                }
            }

            itNeedle = 0;
        }

        return -1;
    }
}