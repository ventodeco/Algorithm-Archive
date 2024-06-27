class Solution {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }

        SortedSet<Integer> sortedSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            sortedSet.add(nums[i]);
        }
        
        int result = 0;
        int maxNumber = 0;
        int prevNumber = 0;
        for (Integer value : sortedSet) {

            if (result == 0) {
                prevNumber = value;
                result++;
                continue;
            }
            
            if (value - 1 != prevNumber) {
                if (maxNumber < result) {
                    maxNumber = result;
                }
                
                result = 1;
                prevNumber = value;
                continue;
            }
            
            prevNumber = value;
            result++;
        }
        
        if (maxNumber < result) {
            maxNumber = result;
        }
        
        return maxNumber;
    }
}