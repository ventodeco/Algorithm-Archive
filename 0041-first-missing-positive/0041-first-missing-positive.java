class Solution {
    public int firstMissingPositive(int[] nums) {
        int missingNumber = 1;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                continue;
            }
            
            set.add(nums[i]);
            
            if (nums[i] == missingNumber) {
                while (set.contains(missingNumber)) {
                    missingNumber++;
                }
            }
        }

        return missingNumber;
    }
}