class Solution {
    
    private static final int MAX_BOARD = 9;
    private static final int MAX_BOX = 3;
    private Set<Integer> integerSet;
    private int tempValue;
    
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < MAX_BOARD; i++) {
            if (! validateRow(i, board)) {
                return false;
            }
            
            if (! validateColumn(i, board)) {
                return false;
            }
        }
        
        int iterationX = 0;
        int iterationY;
        while (iterationX < MAX_BOARD) {
            iterationY = 0;
            while (iterationY < MAX_BOARD) {
                if (! validateBox(iterationX, iterationY, board)) {
                    return false;
                }
                iterationY += 3;
            }
            iterationX += 3;
        }
        
        return true;
    }

    private boolean validateRow(int startX, char[][] board) {
        integerSet = new HashSet<>();
        for (int i = 0; i < MAX_BOARD; i++) {
            if (board[i][startX] == '.') {
                continue;
            }
            tempValue = board[i][startX] - '0';
            if (integerSet.contains(tempValue)) {
                return false;
            }

            integerSet.add(tempValue);
        }

        return true;
    }

    private boolean validateColumn(int startY, char[][] board) {
        integerSet = new HashSet<>();
        for (int i = 0; i < MAX_BOARD; i++) {
            if (board[startY][i] == '.') {
                continue;
            }
            tempValue = board[startY][i] - '0';
            if (integerSet.contains(tempValue)) {
                return false;
            }

            integerSet.add(tempValue);
        }

        return true;
    }

    private boolean validateBox(int startX, int startY, char[][] board) {
        integerSet = new HashSet<>();
        for (int i = startX; i < startX + MAX_BOX; i++) {
            for (int j = startY; j < startY + MAX_BOX; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                tempValue = board[i][j] - '0';
                if (integerSet.contains(tempValue)) {
                    return false;
                }
                
                integerSet.add(tempValue);
            }
        }
        
        return true;
    }
}

// [[".",".",".",".",".",".","5",".","."],
//  [".",".",".",".",".",".",".",".","."],
//  [".",".",".",".",".",".",".",".","."],
//  ["9","3",".",".","2",".","4",".","."],
//  [".",".","7",".",".",".","3",".","."],
//  [".",".",".",".",".",".",".",".","."],
//  [".",".",".","3","4",".",".",".","."],
//  [".",".",".",".",".","3",".",".","."],
//  [".",".",".",".",".","5","2",".","."]]
 