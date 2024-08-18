class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] stops = new int[1001];
        
        int maxTo = -1;

        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            if (to > maxTo) {
                maxTo = to;
            }

            stops[from] += numPassengers;
            stops[to] -= numPassengers;
        }

        int currentCapacity = 0;

        for (int i = 0; i < maxTo; i++) {
            
            if (stops[i] == 0) {
                continue;
            }
            
            currentCapacity += stops[i];
            if (currentCapacity > capacity) {
                return false;
            }
        }

        return true;
    }
}
