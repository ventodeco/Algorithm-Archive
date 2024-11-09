class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        int sumValue;
        while (left < right) {
            sumValue = numbers[left] + numbers[right];
            if (sumValue == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sumValue > target) {
                right--;
                continue;
            }

            left++;
        }

        return new int[]{-1, -1};
    }
}