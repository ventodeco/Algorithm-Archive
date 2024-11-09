class Solution {

    private Set<Integer> set = new HashSet<>();
    private static int LENGTH = 9;
    private char[][] board;
    private int tempValue;

    public boolean isValidSudoku(char[][] board) {
        this.board = board;

        for (int it = 0; it < LENGTH; it++) {
            set.clear();
            if (isDuplicateInRow(it)) {
                return false;
            }
            set.clear();
            if (isDuplicateInCol(it)) {
                return false;
            }
        }

        for (int i = 0; i < LENGTH; i = i + 3) {
            for (int j = 0; j < LENGTH; j = j + 3) {
                set.clear();
                if (isDuplicateInBox(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isDuplicateInBox(int currRow, int currCol) {
        for (int row = currRow; row < currRow + 3; row++) {
            for (int col = currCol; col < currCol + 3; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                tempValue = board[row][col] - '0';

                if (
                    set.contains(tempValue) || 
                    tempValue < 0 || 
                    tempValue > 9
                ) {
                    return true;
                }
                set.add(tempValue);
            }
        }

        return false;
    }

    private boolean isDuplicateInRow(int row) {
        for (int col = 0; col < LENGTH; col++) {
            if (board[row][col] == '.') {
                continue;
            }

            tempValue = board[row][col] - '0';

            if (
                set.contains(tempValue) || 
                tempValue < 0 || 
                tempValue > 9
            ) {
                return true;
            }
            set.add(tempValue);
        }

        return false;
    }

    private boolean isDuplicateInCol(int col) {
        for (int row = 0; row < LENGTH; row++) {
            if (board[row][col] == '.') {
                continue;
            }

            tempValue = board[row][col] - '0';

            if (
                set.contains(tempValue) || 
                tempValue < 0 || 
                tempValue > 9
            ) {
                return true;
            }
            set.add(tempValue);
        }

        return false;
    }
}