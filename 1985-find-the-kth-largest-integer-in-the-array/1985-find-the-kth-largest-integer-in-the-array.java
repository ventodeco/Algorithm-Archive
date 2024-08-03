class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> compare(a, b));
        
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        
        String result = "";
        while (k-- > 0 && ! maxHeap.isEmpty()) {
            result = maxHeap.poll();
        }
        
        return result;
    }
    
    private int compare(String nums1, String nums2) {
        if (nums1.length() != nums2.length()) {
            return Integer.compare(nums2.length(), nums1.length());
        }
        
        return nums2.compareTo(nums1);
    }
}