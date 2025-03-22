class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        int iterator = 0;
        int result = 0;
        while (iterator < k) {
            result = maxHeap.poll();
            iterator++;
        }

        return result;
    }
}