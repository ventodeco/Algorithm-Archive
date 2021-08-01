class Solution {
    public:
        int convertRoman(char letter)
        {
            if (letter == 'I')
                return 1;
            if (letter == 'V')
                return 5;
            if (letter == 'X')
                return 10;
            if (letter == 'L')
                return 50;
            if (letter == 'C')
                return 100;
            if (letter == 'D')
                return 500;
            if (letter == 'M')
                return 1000;
        }

        int romanToInt(string s)
        {
            int _current, _after, sum = 0;
            bool flag;
            
            for (int i = 0; i < s.size(); i++)
            {
                flag = false;
                
                _current = convertRoman(s[i]);
                
                if (i != s.size() - 1)
                {
                    _after = convertRoman(s[i+1]);
                    
                    if (_after > _current)
                        flag = true;
                }
                
                if (flag)
                {
                    sum += (_after - _current);
                    i++;
                } else
                {
                    sum += _current;
                }
            }
            
            return sum;
        }
};