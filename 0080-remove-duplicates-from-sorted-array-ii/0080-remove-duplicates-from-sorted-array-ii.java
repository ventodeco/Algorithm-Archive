class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int low = 1, count = 1;

        for (int high = 1; high < nums.length; high++) {
            if (nums[high] == nums[high - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[low++] = nums[high];
            }
        }

        return low;
    }
}