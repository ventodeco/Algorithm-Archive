class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int res = target - nums[i];
            Integer val = map.getOrDefault(res, null);

            if (val != null) {
                return new int[]{val, i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}