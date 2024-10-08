class Solution {
    private int row;
    private int column;

    public int numIslands(char[][] grid) {
        row = grid.length;
        column = grid[0].length;
        int numOfIsland = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    numOfIsland++;
                    checkIsland(grid, i, j);
                }
            }
        }

        return numOfIsland;
    }

    private void checkIsland(char[][] grid, int i, int j) {
        
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        checkIsland(grid, i - 1, j);
        checkIsland(grid, i + 1, j);
        checkIsland(grid, i, j - 1);
        checkIsland(grid, i, j + 1);

        return;
    }
}