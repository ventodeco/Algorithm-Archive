class Solution {
    public void sortColors(int[] nums) {
        int left = 0, current = 0, right = nums.length - 1, tempValue;
        
        while (current <= right && current < nums.length) {

            if (nums[current] == 0) {
                tempValue = nums[current];
                nums[current] = nums[left];
                nums[left] = tempValue;
                left++;
                current++;
                continue;
            }
            
            if (nums[current] == 2) {
                tempValue = nums[current];
                nums[current] = nums[right];
                nums[right] = tempValue;
                right--;
                continue;
            }

            current++;
        }
    }
}