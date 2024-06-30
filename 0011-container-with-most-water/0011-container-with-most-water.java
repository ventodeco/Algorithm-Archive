class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        
        int tempArea;
        while (low < high) {
            tempArea = (high - low) * Math.min(height[high], height[low]);
            if (maxArea < tempArea) {
                maxArea = tempArea;
            }
            
            if (height[high] > height[low]) {
                low++;
            } else {
                high--;
            }
        }
        
        
        return maxArea;
    }
}