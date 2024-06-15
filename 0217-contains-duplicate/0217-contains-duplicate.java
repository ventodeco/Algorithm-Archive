class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (! integerSet.contains(nums[i])) {
                integerSet.add(nums[i]);
            } else {
                return true;
            }
        }
        
        return false;
    }
}