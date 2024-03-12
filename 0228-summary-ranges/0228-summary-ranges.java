class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> listResult = new ArrayList<>();
        
        if (nums.length == 0) {
            return listResult;
        }
        
        Integer start = null;
        Integer end = null;
        Integer movePointer = 0;
        
        while(movePointer <= nums.length) {
            if (start == null) {
                start = movePointer;
                end = movePointer;
                movePointer++;
                continue;
            }

            if (movePointer < nums.length && nums[end] == nums[movePointer] - 1) {
                end = movePointer;
            } else {
                listResult.add(convertRange(nums[start], nums[end]));
                start = movePointer;
                end = movePointer;
            }
            
            movePointer++;
        }
        
        return listResult;
    }
    
    private String convertRange(Integer start, Integer end) {
        if (start.equals(end)) {
            return start.toString();
        }
        
        return start.toString() + "->" + end.toString();
    }
}