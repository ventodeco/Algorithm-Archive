class Solution {

    public int[] searchRange(int[] nums, int target) {
        
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int pivot = nums.length/2;
        
        int low = 0;
        int high = nums.length - 1;
        int mid = high/2;

        while (low <= high) {

            if (nums[mid] == target) {
                break;
            }

            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            mid = (high+low)/2;
        }

        int left = mid;
        int right = mid;
        int leftResult = -1;
        int rightResult = -1;

        while (left >= 0 && target == nums[left]) {
            leftResult = left;
            left--;
        }
        
        while (right < nums.length && target == nums[right]) {
            rightResult = right;
            right++;
        }

        return new int[]{leftResult, rightResult};
    }
}