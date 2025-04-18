class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        int it = 0;
        int result = -1;
        while (!maxHeap.isEmpty()) {
            result = maxHeap.poll();
            it++;

            if (it == k) {
                break;
            }
        }

        return result;
    }
}