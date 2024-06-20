class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productFromLeft = new int[nums.length];
        int fromLeftTotal = 1;
        for (int i = 0; i < nums.length; i++) {
            fromLeftTotal *= nums[i];
            productFromLeft[i] = fromLeftTotal;
        }

        int[] productFromRight = new int[nums.length];
        int fromRightTotal = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            fromRightTotal *= nums[i];
            productFromRight[i] = fromRightTotal;
        }

        int[] result = new int[nums.length];
        int leftResult;
        int rightResult;
        for (int i = 0; i < nums.length; i++) {
            
            if (i > 0) {
                leftResult = productFromLeft[i - 1];
            } else {
                leftResult = 1;
            }
            
            if (i < nums.length - 1) {
                rightResult = productFromRight[i + 1];
            } else {
                rightResult = 1;
            }
            
            result[i] = leftResult * rightResult;
        }

        return result;
    }
}