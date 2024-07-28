class Solution {
    public int maxProduct(int[] nums) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        
        Integer firstNumber = maxHeap.poll();
        Integer secondNumber = maxHeap.poll();
        
        return (firstNumber - 1) * (secondNumber - 1);
    }
}