class Solution {
    public int deleteGreatestValue(int[][] grid) {
        PriorityQueue<Integer> tempMaxHeap;
        
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            tempMaxHeap = new PriorityQueue<>((a, b) -> b - a);
            for (int j = 0; j < grid[i].length; j++) {
                tempMaxHeap.add(grid[i][j]);
            }
            list.add(tempMaxHeap);
        }

        Boolean shouldBreak = false;
        Integer result = 0;
        Integer maxTemp;
        Integer valueTemp;
        while (! shouldBreak) {
            maxTemp = 0;
            for (PriorityQueue<Integer> maxHeap : list) {
                if (maxHeap.isEmpty()) {
                    shouldBreak = true;
                    break;
                }
                
                valueTemp = maxHeap.poll();
                if (maxTemp < valueTemp) {
                    maxTemp = valueTemp;
                }
            }
            
            result += maxTemp;
        }

        return result;
    }
}