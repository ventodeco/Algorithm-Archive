class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        Integer tempValue;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                tempValue = map.get(s.charAt(i));
                tempValue++;
                map.put(s.charAt(i), tempValue);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        String result = "";
        int[] tempArr;
        while (! maxHeap.isEmpty()) {
            tempArr = maxHeap.poll();
            for (int i = 0; i < tempArr[1]; i++) {
                result += (char) tempArr[0];
            }
        }

        return result;
    }
}
