class Solution {

    private int[][] visited;
    private char[][] board;
    private Integer rowLength;
    private Integer colLength;
    private static int VISITED = 1;
    private static int NOT_VISITED = 0;
    private Integer keeper;
    private String word;

    public boolean exist(char[][] board, String word) {
        rowLength = board.length;
        colLength = board[0].length;
        this.word = word;
        this.board = board;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                keeper = 0;
                visited = new int[rowLength][colLength];
                if (deepDive(row, col)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean deepDive(int row, int col) {
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength) {
            return false;
        }

        if (visited[row][col] == VISITED) {
            return false;
        }

        visited[row][col] = VISITED;

        if (board[row][col] != word.charAt(keeper)) {
            visited[row][col] = NOT_VISITED;
            return false;
        }

        keeper++;

        if (keeper == word.length()) {
            return true;
        }

        if (deepDive(row + 1, col)) {
            return true;
        }

        if (deepDive(row - 1, col)) {
            return true;
        }

        if (deepDive(row, col + 1)) {
            return true;
        }

        if (deepDive(row, col - 1)) {
            return true;
        }

        if (keeper > 0) {
            keeper--;
        }

        return false;
    }
}