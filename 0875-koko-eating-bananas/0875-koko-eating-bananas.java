class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        if (piles.length == 0) {
            return -1;
        }

        Integer mid, low = 0, high = Arrays.stream(piles).max().getAsInt();

        while (low < high) {

            mid = (low + high) / 2;

            if (canFinishAboutHours(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private Boolean canFinishAboutHours(int[] piles, int h, int k) {
        
        int hours = 0;
        for (Integer pile : piles) {
            hours += Math.ceil((double) pile / k);
        }
        
        return hours <= h;
    }
}