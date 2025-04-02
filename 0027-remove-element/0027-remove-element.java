class Solution {
    public int removeElement(int[] nums, int val) {

        int keeper = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }

            nums[keeper] = nums[i];

            keeper++;
        }

        return keeper;
    }
}