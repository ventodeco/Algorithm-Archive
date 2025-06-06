class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for (int row = 1; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {

                if (col == 0) {
                    matrix[row][col] += Math.min(matrix[row - 1][col], matrix[row - 1][col + 1]);
                    continue;
                }

                if (col == colLen - 1) {
                    matrix[row][col] += Math.min(matrix[row - 1][col - 1], matrix[row - 1][col]);
                    continue;
                }

                matrix[row][col] += Math.min(matrix[row - 1][col - 1], Math.min(matrix[row - 1][col], matrix[row - 1][col + 1]));
            }
        }

        int result = Integer.MAX_VALUE;
        for (int col = 0; col < colLen; col++) {
            if (result > matrix[rowLen - 1][col]) {
                result = matrix[rowLen - 1][col];
            }
        }

        return result;
    }
}