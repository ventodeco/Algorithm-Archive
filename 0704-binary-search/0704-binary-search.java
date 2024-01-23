class Solution {
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int pivot;

        while(leftIndex <= rightIndex) {
            
            pivot = leftIndex + ((rightIndex - leftIndex)/2);

            if (nums[pivot] == target) {
                return pivot;
            }

            if (nums[pivot] < target) {
                leftIndex = pivot + 1;
            } else if (nums[pivot] > target) {
                rightIndex = pivot - 1;
            }
        }
        
        return -1;
    }
}