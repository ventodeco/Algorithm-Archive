class Solution {
    public int lengthOfLastWord(String s) {
        String[] wordArr = s.split(" ");
        
        return wordArr[wordArr.length - 1].length();
    }
}