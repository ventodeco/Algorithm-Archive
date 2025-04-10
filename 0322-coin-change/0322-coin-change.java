class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int am = 1; am <= amount; am++) {
            for (int coin : coins) {
                if (am - coin >= 0) {
                    dp[am] = Math.min(1 + dp[am - coin], dp[am]);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}