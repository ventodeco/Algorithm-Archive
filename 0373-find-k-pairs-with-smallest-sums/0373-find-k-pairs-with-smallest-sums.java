class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        for (int i = 0; i < Math.min(nums2.length, k); i++) {
            minHeap.add(new int[]{nums1[0], nums2[i], 0});
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            result.add(Arrays.asList(cur[0], cur[1]));
            
            if (cur[2] < nums1.length - 1) {
                minHeap.add(new int[]{nums1[cur[2] + 1], cur[1], cur[2] + 1});
            }
        }
        
        return result;
    }
}