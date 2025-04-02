class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int keeper = 0;
        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                continue;
            }

            nums[keeper] = nums[i];
            set.add(nums[i]);
            keeper++;
        }

        return keeper;
    }
}