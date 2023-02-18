class Solution {
public:
  int searchInsert(vector<int>& nums, int target) {
    if (nums.size() == 0) {
      return 0;
    }

    int left = 0, right = nums.size() - 1;

    while(left <= right + 1) {
      if (target <= nums[left]) {
        return left;
      }

      if (right <= nums.size() - 1) {
        if (target == nums[right]) {
          return right;
        }

        if (target > nums[right]) {
          return right + 1;
        }
      }

      left++;
      right--;
    }

    return -1;
  }
};
