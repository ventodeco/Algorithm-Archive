class Solution {
    public int majorityElement(int[] nums) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = map.getOrDefault(nums[i], 0);
            val++;
            map.put(nums[i], val);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
        }

        return maxHeap.poll()[0];
    }
}
