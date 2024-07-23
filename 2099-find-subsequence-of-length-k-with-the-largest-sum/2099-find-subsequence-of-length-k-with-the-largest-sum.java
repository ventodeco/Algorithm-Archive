class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new int[]{nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];

        Set<Integer> saveIndex = new HashSet<>();
        
        int[] tempArr;
        while (! minHeap.isEmpty()) {
            tempArr = minHeap.poll();
            saveIndex.add(tempArr[1]);
        }
        
        int[] result = new int[k];
        int iterator = 0;
        for (int i = 0; i < nums.length; i++) {
            
            if (saveIndex.contains(i)) {
                result[iterator] = nums[i];
                iterator++;
            }
        }

        return result;
    }
}