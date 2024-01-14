class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1, 2, 3, 4, 5]
        // leftMap  = 1 -> n-1
        // rightMap = 2 -> n
        
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        
        // rightMap
        int rightIndex = nums.length - 1;
        int rightResult = 1;
        while (rightIndex > 0) {
            rightResult *= nums[rightIndex];
            rightMap.put(rightIndex, rightResult);
            rightIndex--;
        }
        
        // leftMap
        int leftIndex = 0;
        int leftResult = 1;
        while(leftIndex < nums.length - 1) {
            leftResult *= nums[leftIndex];
            leftMap.put(leftIndex, leftResult);
            leftIndex++;
        }
        
        int[] resultList = new int[nums.length];
        Integer multiplyResult = 1;
        for (int i = 0; i < nums.length; i++) {
            if (leftMap.get(i-1) != null) {
                multiplyResult *= leftMap.get(i-1);
            }
            
            if (rightMap.get(i+1) != null) {
                multiplyResult *= rightMap.get(i+1);
            }

            resultList[i] = multiplyResult;
            multiplyResult = 1;
        }
        
        return resultList;
    }
}