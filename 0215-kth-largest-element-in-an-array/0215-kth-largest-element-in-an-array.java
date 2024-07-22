class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        
        Integer iterator = 0;
        while (! maxHeap.isEmpty()) {
            Integer result = maxHeap.poll();
            
            if (k - 1 == iterator) {
                return result;
            }

            iterator++;
        }

        return -1;
    }
}