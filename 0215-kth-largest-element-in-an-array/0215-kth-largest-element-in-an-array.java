class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < 1) {
            return -1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        int val = -1;
        while (k > 0) {
            val = maxHeap.poll();
            k--;
        }

        return val;
    }
}