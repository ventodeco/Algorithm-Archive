class Solution {
    public long getDescentPeriods(int[] prices) {
        long total = 1;
        long count = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                count += 1;
            } else {
                count = 1;
            }
            total += count;
        }

        return total;
    }
}
