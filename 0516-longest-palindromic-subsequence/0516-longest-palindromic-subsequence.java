class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int rows = s.length();
        String sReversed = new StringBuilder(s).reverse().toString();
        int cols = sReversed.length();

        int[][] dp = new int[rows + 1][cols + 1];

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                if (s.charAt(row) == sReversed.charAt(col)) {
                    dp[row][col] = 1 + dp[row + 1][col + 1];
                    continue;
                }

                dp[row][col] = Math.max(dp[row + 1][col], dp[row][col + 1]);
            }
        }

        return dp[0][0];
    }
}