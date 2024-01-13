class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> valueNumsAndIndexMap = new HashMap<>();

        Integer substract;
        for (int i = 0; i < nums.length; i++) {
            substract = target - nums[i];

            if (valueNumsAndIndexMap.get(substract) != null && valueNumsAndIndexMap.get(substract) != i) {
                return new int[]{valueNumsAndIndexMap.get(substract), i};
            }

            valueNumsAndIndexMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}