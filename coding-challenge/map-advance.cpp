#include <bits/stdc++.h>

using namespace std;

// service dependency
// [a, b, c, d, e]
// 
// informasi
// komponen a pakai b
// komponen a pakai c 
// komponen c pakai b
// komponen d pakai e

// a -> b 
// a -> c 
// b -> a 
// tidak boleh ke dirinya sendiri
// [
//      {'a', 'b'},
//      {'a', 'c'},
//      {'b', 'a'},
//      {'c', 'b'}
// ]

// 
// [ 'a' => 1 ]
// [ 'b  => 1 ] 
// 

vector<char> checkValueMore (vector<vector<char>> array)
{
    // O(k) sc
    map<char, int> _map;
    
    // O(n) sc
    vector<char> _res;
    // 'b' : 2,
    // 'c' : 1
    // 'a' : 1,
    // O(1)
    int result = 0;
    // O(1)
    char index;
    
    // O(n) + 2 . O(k) = O(n) tc 
    // O(n) + O(n) + 1 + 1 = O(n) sc
    
    // so for time complexity O(n)
    // and so for space complexity O(n)
    
    
    // O(n) tc
    for (int i = 0; i < array.size(); i++)
    {
        // O(log n) tc
        if (!_map[array[i][1]])
            _map[array[i][1]] = 1;
            
        else 
            _map[array[i][1]]++;
    }
    
    // O(k) tc
    for (auto it = _map.begin(); it != _map.end(); ++it)
    {
        if (result < it->second)
            result = it->second;
    }
    
    // O(k) tc
    for (auto it = _map.begin(); it != _map.end(); ++it)
    {
        if (result == it->second)
            _res.push_back(it->first);
    }
    
    return _res;
}

bool unitTestCheckValueMore(vector<vector<char>> array, vector<char> expected)
{
    vector<char> _expectedResult = checkValueMore(array);
    
    sort(_expectedResult.begin(), _expectedResult.end());
    sort(expected.begin(), expected.end());
    
    if (_expectedResult.size() != expected.size())
        return false;
    
    for (int i = 0; i < _expectedResult.size(); i++)
    {
        if (expected[i] != _expectedResult[i])
            return false;
    }
    
    return true;
}

void testCase() {
    vector<vector<char>> array;
    vector<char> each;
    // { a, b }
    
    each.push_back('a');
    each.push_back('b');
    
    array.push_back(each);
    
    each.pop_back();
    each.pop_back();
    
    each.push_back('a');
    each.push_back('c');
    
    array.push_back(each);
    
    each.pop_back();
    each.pop_back();
    
    each.push_back('b');
    each.push_back('a');
    
    array.push_back(each);
    
    each.pop_back();
    each.pop_back();
    
    each.push_back('c');
    each.push_back('b');
    
    array.push_back(each);
    
    vector<char> result{'b'};
    
    cout << unitTestCheckValueMore(array, result) << endl;
    
    vector<vector<char>> array1;
    
    vector<char> each1;
    // { a, b }
    
    each1.push_back('a');
    each1.push_back('b');
    
    array1.push_back(each1);
    
    each1.pop_back();
    each1.pop_back();
    
    each1.push_back('a');
    each1.push_back('c');
    
    array1.push_back(each1);
    
    each1.pop_back();
    each1.pop_back();
    
    each1.push_back('b');
    each1.push_back('a');
    
    array1.push_back(each1);
    
    each1.pop_back();
    each1.pop_back();
    
    each1.push_back('c');
    each1.push_back('b');
    
    array1.push_back(each1);
    
    each1.pop_back();
    each1.pop_back();
    
    each1.push_back('c');
    each1.push_back('c');
    
    array1.push_back(each1);
    
    vector<char> result1{'b', 'c'};
    
    cout << unitTestCheckValueMore(array1, result1) << endl;
}

int main() {
    testCase();
    
    return 0;
}