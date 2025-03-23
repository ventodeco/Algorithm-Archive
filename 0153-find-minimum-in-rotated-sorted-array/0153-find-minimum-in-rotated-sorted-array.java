class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid < right && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (mid > left && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}