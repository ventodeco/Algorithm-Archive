class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        int tempResult;
        while (left < right) {
            tempResult = target - (numbers[left] + numbers[right]);
            
            if (tempResult == 0) {
                return new int[]{left+1, right+1};
            }
            
            if (tempResult < 0) {
                right--;
            } else {
                left++;
            }
            
        }
        
        return new int[]{-1, -1};
    }
}