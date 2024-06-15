class Solution {
    public boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        
        Arrays.sort(charS);
        Arrays.sort(charT);
        
        if (charS.length != charT.length) {
            return false;
        }

        for (int i = 0; i < charT.length; i++) {
            if (charS[i] != charT[i]) {
                return false;
            }
        }
        
        return true;
    }
}