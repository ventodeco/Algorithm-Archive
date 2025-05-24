class Solution {
    public int minPathSum(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;

        for (int i = 1; i < rowLen; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < colLen; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int row = 1; row < rowLen; row++) {
            for (int col = 1; col < colLen; col++) {
                grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }

        return grid[rowLen - 1][colLen - 1];
    }
}