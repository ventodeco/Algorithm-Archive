class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        int it = 1;
        int result = -1;

        while (!maxHeap.isEmpty() && it <= k) {
            result = maxHeap.poll();
            it++;
        }

        return result;
    }
}