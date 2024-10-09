class Solution {
    private char[][] board;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (findWord(row, col, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    private boolean findWord(int row, int col, String word, int iterator) {
        
        if (iterator >= word.length()) {
            return true;
        }
        
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || word.charAt(iterator) != board[row][col]) {
            return false;
        }

        board[row][col] = '#';

        if (findWord(row + 1, col, word, iterator + 1) ||
            findWord(row - 1, col, word, iterator + 1) ||
            findWord(row, col + 1, word, iterator + 1) ||
            findWord(row, col - 1, word, iterator + 1)
        ) {
            return true;
        }
        
        board[row][col] = word.charAt(iterator);
        return false;
    }
}