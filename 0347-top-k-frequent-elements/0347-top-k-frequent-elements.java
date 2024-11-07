class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        Integer counter;
        for (int i = 0; i < nums.length; i++) {
            counter = map.getOrDefault(nums[i], 1);
            counter += 1;
            map.put(nums[i], counter);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll()[0];
        }

        return result;
    }
}