class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // save on map, <number, totalValue> X
        // try to save on map with in reverse order <totalValue, List<number>> X
        // save on heap for the totalValue maxHeap
        // result pick from heap
        
        Map<Integer, Integer> numsAndCounterMap = new HashMap<>();
        
        Integer totalValue;
        for (int num : nums) {
            if (numsAndCounterMap.get(num) != null) {
                totalValue = numsAndCounterMap.get(num);
                totalValue++;
                numsAndCounterMap.put(num, totalValue);
                
                continue;
            }
            
            numsAndCounterMap.put(num, 0);
        }
        
        Map<Integer, List<Integer>> counterAndNumsList = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        List<Integer> numberList;
        for (Map.Entry<Integer, Integer> entry : numsAndCounterMap.entrySet()) {
            if (counterAndNumsList.get(entry.getValue()) != null) {
                numberList = counterAndNumsList.get(entry.getValue());
                numberList.add(entry.getKey());
                counterAndNumsList.put(entry.getValue(), numberList);
                
                continue;
            }
            
            maxHeap.add(entry.getValue());
            numberList = new ArrayList<>();
            numberList.add(entry.getKey());
            counterAndNumsList.put(entry.getValue(), numberList);
        }
        
        int[] result = new int[k];
        int i = 0;
        while (i < k) {
            numberList = counterAndNumsList.get(maxHeap.poll());
            
            for (Integer number : numberList) {
                result[i] = number;
                i++;
            }
        }
        
        return result;
    }
}