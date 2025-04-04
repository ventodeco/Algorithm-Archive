class Solution {
    public int singleNumber(int[] nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int temp = map.getOrDefault(
                nums[i],
                0
            );

            temp++;
            map.put(nums[i], temp);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(new int[]{entry.getValue(), entry.getKey()});
        }

        while (!minHeap.isEmpty()) {
            int[] temp = minHeap.poll();
            if (temp[0] < 2) {
                return temp[1];
            }
        }

        return -1;
    }
}