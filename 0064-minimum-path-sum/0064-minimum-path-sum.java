class Solution {
    public int minPathSum(int[][] grid) {
        
        int row = grid.length - 1;
        int col = grid[0].length - 1;

        for (int i = row - 1; i >= 0; i--) {
            grid[i][col] = grid[i][col] + grid[i+1][col];
        }

        for (int i = col - 1; i >= 0; i--) {
            grid[row][i] = grid[row][i] + grid[row][i+1];
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                grid[i][j] = Math.min(grid[i][j] + grid[i][j+1], grid[i][j] + grid[i+1][j]);
            }
        }

        return grid[0][0];
    }
}