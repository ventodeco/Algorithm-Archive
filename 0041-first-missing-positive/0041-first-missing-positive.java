class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        
        int result = 1;
        int prevValue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            
            if (prevValue == nums[i]) {
                continue;
            }
            
            if (result != nums[i]) {
                return result;
            }

            prevValue = nums[i];
            result++;
        }
        
        return result++;
    }
}