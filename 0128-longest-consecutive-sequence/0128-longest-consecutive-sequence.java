class Solution {
    public int longestConsecutive(int[] nums) {
        SortedSet<Integer> minSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            minSet.add(nums[i]);
        }

        int maxLong = 0;
        int maxLongTemp = 0;
        Integer prevValue = null, tempValue = null;
        while (! minSet.isEmpty()) {
            tempValue = minSet.first();
            minSet.remove(tempValue);

            if (prevValue == null) {
                maxLongTemp += 1;
                prevValue = tempValue;
                continue;
            }

            if (tempValue - 1 == prevValue) {
                maxLongTemp += 1;
                prevValue = tempValue;
                continue;
            }

            if (maxLongTemp > maxLong) {
                maxLong = maxLongTemp;
                maxLongTemp = 0;
            }
            minSet.add(tempValue);
            prevValue = null;
        }

        if (maxLongTemp > maxLong) {
            maxLong = maxLongTemp;
        }

        return maxLong;
    }
}