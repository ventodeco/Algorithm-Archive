class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    
        for (int i = 0; i < matrix.length; i++) {
            if (target > matrix[i][matrix[0].length - 1]) {
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