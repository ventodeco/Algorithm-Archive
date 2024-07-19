class Solution {
    public int maximumGap(int[] nums) {
        
        if (nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        Integer result = 0;
        Integer tempDiff;
        for (int i = 1; i < nums.length; i++) {
            tempDiff = nums[i] - nums[i - 1];
            if (tempDiff > result) {
                result = tempDiff;
            }
        }
        
        return result;
    }
}