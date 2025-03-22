class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftVal = -1;
        int rightVal = -1;
        boolean isLeftFound = false;
        boolean isRightFound = false;

        while (left <= right) {
            
            if (!isLeftFound) {
                if (nums[left] == target) {
                    leftVal = left;
                    isLeftFound = true;
                } else {
                    left++;
                }
            }
            
            if (!isRightFound) {
                if (nums[right] == target) {
                    rightVal = right;
                    isRightFound = true;
                } else {
                    right--;
                }
                
            }

            if (isRightFound && isLeftFound) {
                break;
            }
        }

        return new int[]{leftVal, rightVal};
    }
}