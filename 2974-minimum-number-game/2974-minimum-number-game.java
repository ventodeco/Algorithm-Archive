class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        int[] result = new int[nums.length];
        
        Integer alice;
        Integer bob;
        Integer iterator = 0;
        while (! minHeap.isEmpty()) {
            alice = minHeap.poll();
            bob = minHeap.poll();
            
            result[iterator] = bob;
            iterator++;

            result[iterator] = alice;
            iterator++;
        }
        
        return result;
    }
}