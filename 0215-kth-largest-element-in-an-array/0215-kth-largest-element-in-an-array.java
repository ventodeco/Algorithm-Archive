class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        int result = -1;
        while (k > 0) {
            result = maxHeap.poll();
            k--;
        }

        return result;
    }
}