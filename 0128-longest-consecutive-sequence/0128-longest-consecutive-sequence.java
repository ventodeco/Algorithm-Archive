class Solution {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return 1;
        }
        
        Set<Integer> minSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            minSet.add(nums[i]);
        }
        
        int longestConsecutive = 0;
        int tempLongestConsecutive = 1;
        Integer previousNumber = null;

        for (Integer number : minSet) {
            if (previousNumber != null && previousNumber == number - 1) {
                tempLongestConsecutive++;
            } else {
                if (longestConsecutive < tempLongestConsecutive) {
                    longestConsecutive = tempLongestConsecutive;
                }
                tempLongestConsecutive = 1;
            } 
            
            previousNumber = number;
        }
        
        
        if (tempLongestConsecutive > longestConsecutive) {
            longestConsecutive = tempLongestConsecutive;
        }

        return longestConsecutive;
    }
}
