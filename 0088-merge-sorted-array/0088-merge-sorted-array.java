class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            minHeap.add(nums1[i]);
        }
        
        for (int i = 0; i < n; i++) {
            minHeap.add(nums2[i]);
        }
        
        int counter = 0;
        while (! minHeap.isEmpty()) {
            nums1[counter] = minHeap.poll();
            counter++;
        }
        
        return;
    }
}