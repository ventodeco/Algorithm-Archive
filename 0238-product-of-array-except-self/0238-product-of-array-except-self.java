class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result = 1;
        int resultWithoutZero = 1;
        int zeroCounter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCounter++;
            }
            resultWithoutZero *= nums[i];
            if (nums[i] != 0) {
                result *= nums[i];
            }
        }

        if (zeroCounter > 1) {
            return new int[nums.length];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = result;
            } else {
                nums[i] = resultWithoutZero/nums[i];
            }
        }

        return nums;
    }
}