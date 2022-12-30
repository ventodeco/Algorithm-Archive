class Solution {
  public int[] runningSum(int[] nums) {
    int resultToNextNumber = 0;

    for (int i = 0; i < nums.length; i++) {
      resultToNextNumber += nums[i];
      nums[i] = resultToNextNumber;
    }

    return nums;
  }
}
