class Solution {
    
    private Set<String> setString = new HashSet<>();
    private PriorityQueue<Integer> copyPQ = new PriorityQueue<>();
    private String hashString;
    
    // notes:
    // - if we found same number from previous index, we can just skip it
    
    // -4,-1,-1,0,1,2
    // -4 + -1 + 2 = -3
    // -4 + 0 + 2 = -2
    // -4 + 1 + 2 = -1
    // -1 + -1 + 2 = 0

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int tempResult;
        List<Integer> numberList;
        List<List<Integer>> result = new ArrayList<>();
        int sum;
        int low;
        int high;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }   

            low = i + 1;
            high = nums.length - 1;
            sum = 0 - nums[i];
            
            while (low < high) {
                if (sum == nums[low] + nums[high]) {
                    numberList = new ArrayList<>();
                    numberList.add(nums[i]);
                    numberList.add(nums[low]);
                    numberList.add(nums[high]);
                    result.add(numberList);

                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }

                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (nums[low] + nums[high] > sum) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        
        return result;
    }
}


