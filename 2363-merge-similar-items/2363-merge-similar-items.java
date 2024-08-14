class Solution {
    
    private int[] tempArr;
    private Integer tempValue;
    private Map<Integer, Integer> map = new HashMap<>();
    private SortedSet<Integer> sortedSet = new TreeSet<>();

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        mapDataToHash(items1);
        mapDataToHash(items2);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList;
        for (Integer value : sortedSet) {
            tempList = new ArrayList<>();
            tempList.add(value);
            tempList.add(map.get(value));
            result.add(tempList);
        }

        return result;
    }

    private void mapDataToHash(int[][] items) {

        for (int i = 0; i < items.length; i++) {
            tempArr = items[i];
            sortedSet.add(tempArr[0]);
            if (map.containsKey(tempArr[0])) {
                tempValue = map.get(tempArr[0]);
                tempValue += tempArr[1];
                map.put(tempArr[0], tempValue);
            } else {
                map.put(tempArr[0], tempArr[1]);
            }
        }
    }
}