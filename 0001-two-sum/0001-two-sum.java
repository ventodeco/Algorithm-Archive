class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int tempValue;
        for (int i = 0; i < nums.length; i++) {
            tempValue = target - nums[i];

            if (map.containsKey(tempValue)) {
                return new int[]{map.get(tempValue), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}