class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashedNums = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            hashedNums.put(nums[i], i);
        }

        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (hashedNums.get(diff) != null && hashedNums.get(diff) != i) {
                return new int[]{i, hashedNums.get(diff)};
            }
        }
        
        return new int[]{};
    }
}