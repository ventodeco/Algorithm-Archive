class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int colLength = matrix.length;
        int lastRow = matrix[0].length - 1;

        for (int i = 0; i < colLength; i++) {
            if (matrix[i][lastRow] < target) {
                continue;
            }

            for (int j = 0; j <= lastRow; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}