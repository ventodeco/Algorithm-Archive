class Solution {
    public int findMin(int[] nums) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        return minHeap.peek();
    }
}