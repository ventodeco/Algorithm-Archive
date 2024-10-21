class Solution {
    
    private int[][] visited;
    private char[][] grid;
    private static int VISITED = 1;
    private static int NOT_VISITED = 0;
    private static Character ISLAND = '1';
    private int counter;
    
    private void dfs(int row, int col) {
        
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (visited[row][col] == VISITED) {
            return;
        }

        visited[row][col] = VISITED;

        if (grid[row][col] != ISLAND) {
            return;
        }

        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        
        if (grid.length == 0) {
            return 0;
        }

        if (grid[0].length == 0) {
            return 0;
        }

        visited = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                visited[i][j] = NOT_VISITED;
            }
        }

        counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ISLAND && visited[i][j] == NOT_VISITED) {
                    counter++;
                    dfs(i, j);
                } else {
                    visited[i][j] = VISITED;
                }
            }
        }

        return counter;
    }
}