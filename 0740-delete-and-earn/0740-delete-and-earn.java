class Solution {
    public int deleteAndEarn(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        SortedSet<Integer> sortedSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            int tempVal = map.getOrDefault(nums[i], 0);

            tempVal += nums[i];
            map.put(nums[i], tempVal);
            sortedSet.add(nums[i]);
        }

        List<Integer> list = new ArrayList<>(sortedSet);

        int[] dp = new int[sortedSet.size()];

        for (int i = 0; i < list.size(); i++) {
            int currIdx = list.get(i);
            int currVal = map.get(currIdx);

            if (i == 0) {
                dp[i] = currVal;
            } else if (currIdx == list.get(i - 1) + 1) {
                dp[i] = Math.max(dp[i - 1], (i >= 2) ? dp[i - 2] + currVal : currVal);
            } else {
                dp[i] = dp[i - 1] + currVal;
            }
        }

        return dp[sortedSet.size() - 1];
    }
}