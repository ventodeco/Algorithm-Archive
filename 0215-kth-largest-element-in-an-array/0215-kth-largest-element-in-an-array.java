class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        
        Integer kth = nums.length - k;
        while (! maxHeap.isEmpty()) {
            if (kth == 0) {
                return maxHeap.poll();
            }
            maxHeap.poll();
            kth--;
        }
        
        return -1;
    }
}