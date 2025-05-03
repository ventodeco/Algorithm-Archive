class Solution {
    public int climbStairs(int n) {
        
        if (n <= 2) {
            return n;
        }

        // n = 1 -> 1
        // n = 2 -> 2
        // n = 3 -> 3
        // n = 4 -> 5

        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}