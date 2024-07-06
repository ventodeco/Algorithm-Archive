class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = stringToMap(s1, new HashMap<>());
        Map<Character, Integer> s2Map = new HashMap<>();        

        Integer leftPointer = 0;
        Integer rightPointer = s1.length();
        Integer tempValue;

        while (leftPointer < rightPointer && leftPointer < s2.length()) {
            if (s2Map.containsKey(s2.charAt(leftPointer))) {
                tempValue = s2Map.get(s2.charAt(leftPointer));
                tempValue++;
                s2Map.put(s2.charAt(leftPointer), tempValue);
            } else {
                s2Map.put(s2.charAt(leftPointer), 1);
            }
            leftPointer++;
        }

        leftPointer = 0;
        rightPointer = s1.length();

        while (leftPointer < rightPointer && rightPointer < s2.length()) {
            if (s1Map.equals(s2Map)) {
                return true;
            }

            tempValue = s2Map.get(s2.charAt(leftPointer));
            tempValue--;

            if (tempValue == 0) {
                s2Map.remove(s2.charAt(leftPointer));
            } else {
                s2Map.put(s2.charAt(leftPointer), tempValue);
            }

            if (s2Map.containsKey(s2.charAt(rightPointer))) {
                tempValue = s2Map.get(s2.charAt(rightPointer));
                tempValue++;
                s2Map.put(s2.charAt(rightPointer), tempValue);
            } else {
                s2Map.put(s2.charAt(rightPointer), 1);
            }

            leftPointer++;
            rightPointer++;
        }

        if (s1Map.equals(s2Map)) {
            return true;
        }
        
        return false;
    }

    private Map<Character, Integer> stringToMap(String s, Map<Character, Integer> map) {

        int tempValue;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                tempValue = map.get(s.charAt(i));
                tempValue++;
                map.put(s.charAt(i), tempValue);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        return map;
    }
}