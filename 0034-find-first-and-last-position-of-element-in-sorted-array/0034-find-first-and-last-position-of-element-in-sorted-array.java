class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int low = -1;
        int high = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (low == -1) {
                    low = i;
                    high = i;
                } else {
                    high = i;
                }
            }
            
            if (target < nums[i]) {
                break;
            }
        }
        
        return new int[]{low, high};
    }
}