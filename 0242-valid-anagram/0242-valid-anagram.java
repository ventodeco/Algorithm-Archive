class Solution {
    public boolean isAnagram(String s, String t) {

        char[] chArr = s.toCharArray();
        Arrays.sort(chArr);
        s = new String(chArr);

        chArr = t.toCharArray();
        Arrays.sort(chArr);
        t = new String(chArr);

        if (s.length() != t.length()) {
            return false;
        }

        int leftS = 0;
        int leftT = 0;
        int right = s.length() - 1;

        while (leftS <= right || leftT <= right) {

            if (!Character.isLetter(s.charAt(leftS))) {
                leftS++;
                continue;
            }

            if (!Character.isLetter(t.charAt(leftT))) {
                leftT++;
                continue;
            }

            if (s.charAt(leftS) != t.charAt(leftT)) {
                return false;
            }

            leftS++;
            leftT++;
        }

        return true;
    }
}