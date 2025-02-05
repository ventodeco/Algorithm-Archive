class Solution {
    public int removeDuplicates(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int keeper = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                nums[keeper] = nums[i];
                keeper++;
                continue;
            }

            if (map.get(nums[i]) >= 2) {
                continue;
            }

            nums[keeper] = nums[i];
            map.put(nums[i], 2);
            keeper++;
        }

        return keeper;
    }
}