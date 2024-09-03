class Solution {
    public List<Integer> topStudents(String[] positiveFeedback, String[] negativeFeedback, String[] report, int[] studentId, int k) {
        
        Map<String, Integer> feedbackWithValue = new HashMap<>();
        feedbackWithValue = mappingFeedback(positiveFeedback, feedbackWithValue, 3);
        feedbackWithValue = mappingFeedback(negativeFeedback, feedbackWithValue, -1);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b[1] == a[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        int[] temp;
        int tempVal;
        for (int i = 0; i < report.length; i++) {
            tempVal = calculateReport(report[i], feedbackWithValue);
            temp = new int[]{studentId[i], tempVal};
            maxHeap.add(temp);
        }

        List<Integer> result = new ArrayList<>();
        int iterator = 1;
        while (! maxHeap.isEmpty()) {
            
            result.add(maxHeap.poll()[0]);
            
            if (iterator == k) {
                break;
            }

            iterator++;
        }

        return result;
    }

    private Map<String, Integer> mappingFeedback(String[] positiveFeedback, Map<String, Integer> map, int value) {
        
        for (int i = 0; i < positiveFeedback.length; i++) {
            map.put(positiveFeedback[i], value);
        }

        return map;
    }

    private int calculateReport(String str, Map<String, Integer> feedback) {
        int result = 0;
        
        String[] strArr = str.split(" ");
        Integer val;
        for (int i = 0; i < strArr.length; i++) {
            val = feedback.get(strArr[i]);
            if (val != null) {
                result += val;
            }  
        }

        return result;
    }
}