class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> setCharacter = new HashSet<>();
        int longestSubstring = 0;
        int tempSumSubstring = 0;
        
        int leftPointer = 0;
        int iterator;
        
        while (leftPointer < s.length()) {
            iterator = leftPointer;
            while (iterator < s.length()) {
                
                if (setCharacter.contains(s.charAt(iterator))) {
                    
                    if (longestSubstring < tempSumSubstring) {
                        longestSubstring = tempSumSubstring;
                    }

                    tempSumSubstring = 0;
                    setCharacter.clear();
                    break;
                    
                } else {
                    setCharacter.add(s.charAt(iterator));
                    tempSumSubstring += 1;
                }

                iterator++;
            }
            
            leftPointer++;
        }
        
        if (longestSubstring < tempSumSubstring) {
            longestSubstring = tempSumSubstring;
        }
        
        return longestSubstring;
    }
}
