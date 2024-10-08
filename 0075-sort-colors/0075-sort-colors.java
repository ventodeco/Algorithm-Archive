class Solution {
    public void sortColors(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
        
        int iterator = 0;
        while (! minHeap.isEmpty()) {
            nums[iterator] = minHeap.poll();
            iterator++;
        }
    }
}