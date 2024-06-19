class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapFrequentNumber = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (mapFrequentNumber.get(nums[i]) != null) {
                mapFrequentNumber.put(nums[i], mapFrequentNumber.get(nums[i]) + 1);
            } else {
                mapFrequentNumber.put(nums[i], 1);
            }
        }

        Map<Integer, List<Integer>> numberBasedOnFrequentMap = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> tempList;
        for (Map.Entry<Integer, Integer> entry : mapFrequentNumber.entrySet()) {
            if (numberBasedOnFrequentMap.get(entry.getValue()) != null) {
                tempList = numberBasedOnFrequentMap.get(entry.getValue());
                tempList.add(entry.getKey());
                numberBasedOnFrequentMap.put(entry.getValue(), tempList);
            } else {
                maxHeap.add(entry.getValue());
                tempList = new ArrayList<>();
                tempList.add(entry.getKey());
                numberBasedOnFrequentMap.put(entry.getValue(), tempList);
            }
        }

        int pollNumber;
        List<Integer> resultList = new ArrayList<>();
        int kTarget = k;
        while (!maxHeap.isEmpty()) {
            pollNumber = maxHeap.poll();
            
            for (Integer value : numberBasedOnFrequentMap.get(pollNumber)) {
                if (kTarget <= 0) {
                    break;
                }
                resultList.add(value);
                kTarget--;
                
            }
        }
        
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}