class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs.length == 0) {
            return List.of(List.of());
        }

        Map<String, List<String>> groupAnagramMap = new HashMap<>();
        String sortedString;
        List<String> listString;
        for (int i = 0; i < strs.length; i++) {
            sortedString = getSortedString(strs[i]);

            listString = groupAnagramMap.get(sortedString);
            if (listString != null) {
                listString.add(strs[i]);
            } else {
                listString = new ArrayList<>();
                listString.add(strs[i]);
                groupAnagramMap.put(sortedString, listString);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> groupAnagram : groupAnagramMap.entrySet()) {
            result.add(groupAnagram.getValue());
        }
        
        return result;
    }

    private String getSortedString(String str) {
        char[] strFromChar = str.toCharArray();
        
        Arrays.sort(strFromChar);
        
        String newString = "";
        for (int i = 0; i < strFromChar.length; i++) {
            newString += strFromChar[i];
        }
        
        return newString;
    }
}