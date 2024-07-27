class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> winnerMap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < score.length; i++) {
            winnerMap.add(new int[]{score[i], i});
        }

        String[] strArray = new String[score.length];

        int[] tempInt;
        Integer iterator = 1;
        String gift;
        while (! winnerMap.isEmpty()) {
            tempInt = winnerMap.poll();
            strArray[tempInt[1]] = setGift(iterator);
            iterator++;
        }
        return strArray;
    }
    
    private String setGift(Integer iterator) {
        if (iterator == 1) {
            return "Gold Medal";
        } else if (iterator == 2) {
            return "Silver Medal";
        } else if (iterator == 3) {
            return "Bronze Medal";
        }
        
        return String.valueOf(iterator);
    }
}