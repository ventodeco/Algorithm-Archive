class Solution {
  public int maxArea(int[] height) {
      int left = 0;
      int right = height.length - 1;
      int mostWater = 0;
      int longArea, widthArea, result;

      while (left < right) {
          longArea = right - left;
          widthArea = Math.min(height[left], height[right]);
          result = longArea * widthArea;
          mostWater = Math.max(mostWater, result);

          if (height[left] < height[right]) {
              left++;
          } else if (height[left] > height[right]) {
              right--;
          } else {
              left++;
              right--;
          }
      }

      return mostWater;
  }
}
