class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counterNums = new HashMap<>();
        
        Integer counter;
        for (Integer num : nums) {
            
            if (counterNums.containsKey(num)) {
                counter = counterNums.get(num);
                counter += 1;
                counterNums.put(num, counter);
                
            } else {
                counterNums.put(num, 1);
            }
        }
        
        Integer size = nums.length / 2;
        Integer maxCounter = -1;
        Integer numValue = -1;
        for (Map.Entry<Integer, Integer> num: counterNums.entrySet()) {
            
            if (num.getValue() > maxCounter) {
                maxCounter = num.getValue();
                numValue = num.getKey();
            }
        }
        
        return maxCounter > size ? numValue : -1;
    }
}