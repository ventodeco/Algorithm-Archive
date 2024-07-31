class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                minHeap.add(matrix[i][j]);
            }
        }
        
        Integer result = -1;
        Integer iterator = 1;
        Integer tempValue;
        while (! minHeap.isEmpty()) {
            tempValue = minHeap.poll();
            if (iterator == k) {
                result = tempValue;
                break;
            }

            iterator++;
        }
        
        return result;
    }
}