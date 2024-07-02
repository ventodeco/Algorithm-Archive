class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int tempSum;
        int leftPointer = 0;
        for (int i = 0; i < prices.length; i++) {
            
            if (i == leftPointer) {
                continue;
            }
            
            if (prices[leftPointer] > prices[i]) {
                leftPointer = i;
            }
            
            tempSum = prices[i] - prices[leftPointer];
            if (maxProfit < tempSum) {
                maxProfit = tempSum;
            }
        }

        return maxProfit;
    }
}