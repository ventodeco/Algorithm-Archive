class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> result;
        map<int, int> _map;

        for (int i = 0; i < numbers.size(); i++) {
            _map[numbers[i]] = i;
        }

        int _find;
        for (int i = 0; i < numbers.size(); i++) {
            _find = target - numbers[i];

            if (_map[_find] && i != _map[_find]) {
                result.push_back(i+1);
                result.push_back(_map[_find] + 1);
                break;
            }
        }

        return result;
    }
};