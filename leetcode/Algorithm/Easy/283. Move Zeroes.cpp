class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int temp, it = -1;

        for (int i = 0; i < nums.size(); i++) {
            it++;
            if (nums[it] != 0)
                continue;

            temp = nums[it];
            nums.erase(nums.begin() + it, nums.begin() + it + 1);
            nums.push_back(temp);
            it--;
        }
    }
};