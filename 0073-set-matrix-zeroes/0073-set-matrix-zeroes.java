class Solution {

    private Integer COL_LENGTH;
    private Integer ROW_LENGTH;

    public void setZeroes(int[][] matrix) {
        Set<String> set = new HashSet<>();

        ROW_LENGTH = matrix.length;
        COL_LENGTH = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    set.add(String.valueOf(i) + "," + String.valueOf(j));
                }
            }
        }

        for (String str : set) {
            String[] strArr = str.split(",");
            modifyMatrix(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), matrix);
        }
    }

    private void modifyMatrix(int row, int col, int[][] matrix) {
        for (int i = 0; i < ROW_LENGTH; i++) {
            matrix[i][col] = 0;
        }

        for (int i = 0; i < COL_LENGTH; i++) {
            matrix[row][i] = 0;
        }
    }
}