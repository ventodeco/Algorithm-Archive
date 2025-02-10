class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String sortedString = new String(ch);
            List<String> list = map.getOrDefault(sortedString, new ArrayList<>());

            list.add(strs[i]);

            map.put(sortedString, list);
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}