class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowLen - 1][colLen - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 0; i < colLen; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int row = 1; row < rowLen; row++) {
            for (int col = 1; col < colLen; col++) {

                if (obstacleGrid[row][col] == 1) {
                    continue;
                }

                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        return dp[rowLen - 1][colLen - 1];
    }
}