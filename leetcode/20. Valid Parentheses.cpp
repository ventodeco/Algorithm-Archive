class Solution 
{
    public:
        bool isValid(string s)
        {
            stack<char> _stack;

            for (int i = 0; i < s.length(); i++)
            {
                if (s[i] == '{' || s[i] == '[' || s[i] == '(')
                {
                    _stack.push(s[i]);
                } else if (s[i] == '}' && !_stack.empty() && _stack.top() == '{') 
                {
                    _stack.pop();
                } else if (s[i] == ']' && !_stack.empty() && _stack.top() == '[')
                {
                    _stack.pop();
                } else if (s[i] == ')' && !_stack.empty() && _stack.top() == '(')
                {
                    _stack.pop();
                } else 
                {
                    return false;
                }
            }

            return _stack.empty();
        }
};