class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int sizeColumn = matrix[0].length - 1;
        
        for (int i = 0; i < matrix.length; i++) {
            if (target > matrix[i][sizeColumn]) {
                continue;
            }
            
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        
        return false;
    }
}