class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = 0;
        int closestTarget = Integer.MAX_VALUE;
        int tempSum;

        for (int i = 0; i < nums.length; i++) {
            
            left = i+1;
            right = nums.length - 1;
            while (left < right) {

                tempSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(tempSum - target) < Math.abs(closestTarget - target)) {
                    closestTarget = tempSum;
                }
                
                if (tempSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return closestTarget;
    }
}