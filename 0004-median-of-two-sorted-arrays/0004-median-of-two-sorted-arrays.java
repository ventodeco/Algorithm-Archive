class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int mid = total / 2;

        int iterator = 0, nums1It = 0, nums2It = 0;
        int tempValue = 0, prevValue = 0;

        while (iterator <= mid) {
            prevValue = tempValue;

            if (nums1It < nums1.length && (nums2It >= nums2.length || nums1[nums1It] <= nums2[nums2It])) {
                tempValue = nums1[nums1It++];
            } else {
                tempValue = nums2[nums2It++];
            }
            
            iterator++;
        }

        if (total % 2 == 0) {
            return (prevValue + tempValue) / 2.0;
        } else {
            return tempValue;
        }
    }
}