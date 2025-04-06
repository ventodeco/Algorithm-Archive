class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int am = 1; am < amount + 1; am++) {
            for (int coin : coins) {
                if (am - coin >= 0) {
                    dp[am] = Math.min(dp[am], 1 + dp[am - coin]);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}