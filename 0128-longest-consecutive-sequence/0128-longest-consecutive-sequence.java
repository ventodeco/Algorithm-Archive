class Solution {
    public int longestConsecutive(int[] nums) {
        SortedSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int result = 0;
        Integer temp = 0;

        Integer prev = null;

        for (Integer number : set) {

            if (prev == null) {
                prev = number;
                temp = 1;
                continue;
            }

            if (number - 1 == prev) {
                temp++;
                prev = number;
                continue;
            }

            if (temp > result) {
                result = temp;
            }

            temp = 1;
            prev = number;
        }

        if (temp > result) {
            result = temp;
        }

        return result;
    }
}