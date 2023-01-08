class Solution {
  public:
    vector<int> twoSum(vector<int> nums, int target)
    {
      map<int, int> _map;
      vector<int> arr;

      for (int i = 0; i < nums.size(); i++)
      {
        _map[nums[i]] = i;
      }

      int result;

      for (int i = 0; i < nums.size(); i++)
      {
        result = target - nums[i];

        if (_map[result] && _map[result] != i)
        {
          arr.push_back(_map[i]);
          arr.push_back(i);

          break;
        }
      }

      return arr;
    }
};
