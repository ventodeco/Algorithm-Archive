class Solution {

    private static int LIVE = 1;
    private static int DEAD = 0;
    private static int ROW_SIZE;
    private static int COL_SIZE;

    private int[][] board;

    public void gameOfLife(int[][] board) {
        this.board = board;
        ROW_SIZE = board.length;
        COL_SIZE = board[0].length;
        List<int[]> liveList = new ArrayList<>();
        List<int[]> deadList = new ArrayList<>();

        for (int row = 0; row < ROW_SIZE; row++) {
            for (int col = 0; col < COL_SIZE; col++) {
                if (isEligibleToLife(row, col)) {
                    liveList.add(new int[]{row, col});
                    continue;
                }
                deadList.add(new int[]{row, col});
            }
        }

        for (int[] list : liveList) {
            board[list[0]][list[1]] = LIVE;
        }

        for (int[] list : deadList) {
            board[list[0]][list[1]] = DEAD;
        }
    }

    private boolean isEligibleToLife(int row, int col) {

        if (board[row][col] == LIVE) {
            int live = checkNeighbor(row, col);

            if (live < 2 || live > 3) {
                return false;
            }

            return true;
        }

        int live = checkNeighbor(row, col);

        return live == 3;
    }

    private int checkNeighbor(int row, int col) {
        int live = 0;
        if (
            row - 1 >= 0 &&
            board[row - 1][col] == LIVE
        ) {
            live += 1;
        }

        if (
            row + 1 < ROW_SIZE &&
            board[row + 1][col] == LIVE) {
            live += 1;
        }

        if (
            col - 1 >= 0 &&
            board[row][col - 1] == LIVE
        ) {
            live += 1;
        }

        if (
            col + 1 < COL_SIZE &&
            board[row][col + 1] == LIVE
        ) {
            live += 1;
        }

        if (
            row - 1 >= 0 &&
            col - 1 >= 0 &&
            board[row - 1][col - 1] == LIVE
        ) {
            live += 1;
        }

        if (
            row + 1 < ROW_SIZE &&
            col - 1 >= 0 &&
            board[row + 1][col - 1] == LIVE
        ) {
            live += 1;
        }

        if (
            row - 1 >= 0 &&
            col + 1 < COL_SIZE &&
            board[row - 1][col + 1] == LIVE
        ) {
            live += 1;
        }

        if (
            row + 1 < ROW_SIZE &&
            col + 1 < COL_SIZE &&
            board[row + 1][col + 1] == LIVE
        ) {
            live += 1;
        }

        return live;
    }
}