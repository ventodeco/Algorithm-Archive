class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int substract = target - nums[i];

            Integer idx = map.get(substract);
            if (idx != null) {
                return new int[]{i, idx};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}