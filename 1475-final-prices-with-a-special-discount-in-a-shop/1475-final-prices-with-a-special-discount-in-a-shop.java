class Solution {
    public int[] finalPrices(int[] prices) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];

        result[prices.length - 1] = prices[prices.length - 1];
        stack.push(prices[prices.length - 1]);

        for (int i = prices.length - 2; i >= 0; i--) {
            
            if (!stack.isEmpty() && stack.peek() < prices[i]) {
                result[i] = prices[i] - stack.peek();
                stack.add(prices[i]);
            } else {
                
                while (!stack.empty() && stack.peek() > prices[i]) {
                    stack.pop();
                }
                
                if (stack.empty()) {
                    result[i] = prices[i];
                    stack.add(prices[i]);
                } else {
                    result[i] = prices[i] - stack.peek();
                    stack.add(prices[i]);
                }
            }
        }

        return result;
    }
}