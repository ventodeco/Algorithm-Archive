class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < Math.min(nums2.length, k); i++) {
            minHeap.add(new int[]{nums1[0], nums2[i], 0});
        }

        List<List<Integer>> result = new ArrayList<>();
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] arr = minHeap.poll();
            result.add(List.of(arr[0], arr[1]));

            if (arr[2] < nums1.length) {
                minHeap.add(new int[]{nums1[arr[2] + 1], arr[1], arr[2] + 1});
            }
        }

        return result;
    }
}