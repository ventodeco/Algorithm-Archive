class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        Integer sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];

            if (sum == target && left != right) {
                return new int[]{left + 1, right + 1};
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }
}