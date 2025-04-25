class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        addToHeap(nums1, m, minHeap);
        addToHeap(nums2, n, minHeap);

        int it = 0;
        while (!minHeap.isEmpty()) {
            nums1[it] = minHeap.poll();
            it++;
        }
    }

    private void addToHeap(int[] num, int size, PriorityQueue<Integer> minHeap) {
        for (int i = 0; i < size; i++) {
            minHeap.add(num[i]);
        }
    }
}