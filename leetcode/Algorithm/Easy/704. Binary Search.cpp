class Solution {
    public:
    int search(vector<int> &nums, int target) {
        int i = 0, k = nums.size() - 1;

        while (i <= k) {
            if (nums[i] == target)
                return i;

            if (nums[k] == target)
                return k;

            i++;
            k--;
        }

        return -1;
    }
};