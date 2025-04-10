class Solution {
    public int coinChange(int[] coins, int amount) {


        // amount 0 -> [0]
        // amount 1 -> [-1]
        // amount 2 -> [2]
        // amount 3 -> [-1]

        // amount val -> 11
        // amount 0 -> [0]
        // amount 1 -> [1]
            // 1,2,5 -> 1 - 1 = 0 | 1 - 2 = -1 | 1 - 5 = -4 
            // Min(amounts[1] -> amount + 1, 1 + amounts[0])| Min(amount + 1, 1) | 1
            // amounts[1] = 1
        // amount 2 -> [2]
        // amount 3 -> [[1,2], [1,1,1], [2,1]]
        // amount 4 -> [[1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2]]

        int[] amounts = new int[amount + 1];
        Arrays.fill(amounts, amount + 1);

        amounts[0] = 0;

        for (int am = 1; am <= amount; am++) {
            for (int coin : coins) {
                if (am - coin >= 0) {
                    amounts[am] = Math.min(amounts[am], 1 + amounts[am - coin]);
                }
            }
        }

        return amounts[amount] != amount + 1 ? amounts[amount] : -1;
    }
}
