class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = stringToMap(s1, new HashMap<>());
        Map<Character, Integer> s2Map = new HashMap<>();        

        Integer leftPointer;
        Integer rightPointer;
        Integer tempValue;
        for (int i = 0; i < s2.length(); i++) {
            if (! s1Map.containsKey(s2.charAt(i))) {
                continue;
            }

            leftPointer = i;
            rightPointer = i + s1.length();
            s2Map.clear();

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

            if (s1Map.equals(s2Map)) {
                System.out.println(s1Map);
                System.out.println(s2Map);
                return true;
            }
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