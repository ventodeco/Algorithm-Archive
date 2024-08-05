class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], -1);
        }

        for (int i = 0; i < nums2.length; i++) {
            while(!stack.empty() && nums2[i] > stack.peek()){
                map.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
        }
        
        int[] result = new int[nums1.length];
        int j = 0;

        for (int i : nums1) {
            result[j] = map.getOrDefault(i, -1);
            j++;
        }

        return result;
    }
}