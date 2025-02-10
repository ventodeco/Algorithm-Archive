class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = convertToMap(ransomNote);
        Map<Character, Integer> magazineMap = convertToMap(magazine);

        for (Map.Entry<Character, Integer> entry : ransomMap.entrySet()) {
            if (! magazineMap.containsKey(entry.getKey())) {
                return false;
            }

            if (magazineMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> convertToMap(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            int value = map.getOrDefault(str.charAt(i), 0);

            value++;
            map.put(str.charAt(i), value);
        }

        return map;
    }
}