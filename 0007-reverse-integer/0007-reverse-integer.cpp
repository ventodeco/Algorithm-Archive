class Solution {
public:
    int reverse(int x) {
        string convertInt = to_string(x);
        
        string result = "";
        
        if (convertInt[0] == '-') {
            result += convertInt[0];
        }
        
        for (int i = convertInt.size() - 1; i >= 0; i--) {
            result += convertInt[i];
        }
        
        try {
            return stoi(result);
        } catch (...) {
            return 0;
        }
    }
};