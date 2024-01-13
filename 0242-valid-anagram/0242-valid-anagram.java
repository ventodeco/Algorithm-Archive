class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }
        
        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        s = String.valueOf(sChar);
        
        char[] tChar = t.toCharArray();
        Arrays.sort(tChar);
        t = String.valueOf(tChar);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}