class Solution {
public:
    int convertRomanToInteger(char charRoman) {
        // {'I', 1}
        // {'V', 5}
        map<char, int> mapRomanToInteger {
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000}
        };

        return mapRomanToInteger[charRoman];
    }

    int romanToInt(string s) {
        // ketika s = 0
        // sweet case ketika VI = 5 + 1; V
        // ada 2 string yang lebih besar next nya V
        // misal : IX = 1 10 -> 9

        if (s.size() == 0) {
            return 0;
        }

        int result = 0;
        int nextNumber;
        int currentNumber = 0;

        for (int i = 0; i < s.size(); i++) {
            currentNumber = convertRomanToInteger(s[i]);

            nextNumber = -1;

            if (i+1 <= s.size() - 1) {
                nextNumber = convertRomanToInteger(s[i+1]);
            }

            if (nextNumber > currentNumber) {
                currentNumber = nextNumber - currentNumber;
                i++;
            }

            result += currentNumber;
        }

        return result;
    }
}
