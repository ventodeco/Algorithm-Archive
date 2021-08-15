// input
// 10
// # asdasd
// Carsaldkasdka asd asdkjas dkas dkasjd askjd 
// sadas aksda sdkjasd kasjd kj
// ## asdasd
// askda sdaslkdaslkd alskd alksd laskd alskd llksadald alsd alsk
// # asdsad
// asld askdja sdkjas dkjas dkjas dkjas d
// ## asdasd
// aaa
// # asdasd

// output
// 1. asdasd
// 1. 1. asdasd
// 2. asdsad
// 2. 1. asdasd
// 3. asdasd



#include <bits/stdc++.h>

using namespace std;

int main() {
    
    int n;
    cin >> n;
    
    vector<string> array;
    vector<string> result;
    
    string temp = "";
    
    for(int i = 0; i <= n; i++)
    {
        getline(cin, temp);
        
        array.push_back(temp);
    }
    
    int count_begin = 0, count_next = 0;
    
    for (int i = 0; i < array.size(); i++)
    {
        temp = "";
        if (array[i][0] == '#' && array[i][1] == '#')
        {
            array[i].erase(array[i].begin(), array[i].begin() + 3);
            count_next++;
            temp += to_string(count_begin) + ". " + to_string(count_next) + ". " + array[i];
            result.push_back(temp);
        }
        else if (array[i][0] == '#')
        {
            array[i].erase(array[i].begin(), array[i].begin() + 2);
            count_begin++;
            temp += to_string(count_begin) + ". " + array[i];
            result.push_back(temp);
            count_next = 0;
        }
    }
    
    for (int i = 0; i < result.size(); i++)
    {
        cout << result[i] << endl;
    }
    
    
    
    return 0;
}