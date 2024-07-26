class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        Integer tempCounter;
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                tempCounter = map.get(words[i]);
                tempCounter++;
                map.put(words[i], tempCounter);
            } else {
                map.put(words[i], 1);
            }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        Map<Integer, PriorityQueue<String>> stringMap = new HashMap<>();

        String word;
        Integer counter;
        PriorityQueue<String> minHeapString;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            word = entry.getKey();
            counter = entry.getValue();
            
            if (! maxHeap.contains(counter)) {
                maxHeap.add(counter);
            }

            if (stringMap.containsKey(counter)) {
                minHeapString = stringMap.get(counter);
                minHeapString.add(word);
                stringMap.put(counter, minHeapString);
            } else {
                minHeapString = new PriorityQueue<>();
                minHeapString.add(word);
                stringMap.put(counter, minHeapString);
            }
        }
        
        Integer iterator = 0;
        String tempString;
        List<String> topK = new ArrayList<>();
        while (! maxHeap.isEmpty()) {
            tempCounter = maxHeap.poll();
            minHeapString = stringMap.get(tempCounter);
            
            while (! minHeapString.isEmpty()) {
                tempString = minHeapString.poll();
                topK.add(tempString);

                if (topK.size() >= k) {
                    break;
                }
            }
            
            if (topK.size() >= k) {
                break;
            }
        }
        
        return topK;
    }
}