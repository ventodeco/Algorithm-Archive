class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapStringList = new HashMap<>();
        
        char[] strArray;
        String sortedString;
        List<String> existingStringList;
        List<String> newStringList;
        for (String str : strs) {
            strArray = str.toCharArray();
            Arrays.sort(strArray);
            sortedString = String.valueOf(strArray);
            
            if (mapStringList.get(sortedString) != null) {
                existingStringList = mapStringList.get(sortedString);
                existingStringList.add(str);
                mapStringList.put(sortedString, existingStringList);
                continue;
            }
            
            newStringList = new ArrayList<>();
            newStringList.add(str);
            mapStringList.put(sortedString, newStringList);
        }
        
        List<List<String>> resultString = new ArrayList<>();
        
        for (Map.Entry<String, List<String>> entry : mapStringList.entrySet()) {
            existingStringList = entry.getValue();
            resultString.add(existingStringList);
        }
        
        return resultString;
    }
}