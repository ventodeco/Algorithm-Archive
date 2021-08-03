class Solution 
{
    public:
        string longestCommonPrefix(vector<string>& strs) {
            
            string prefixResult = "";

            if (strs.size() == 0)
                return prefixResult;

            for (int i = 0; i < strs[0].length(); i++)
            {
                for (int j = 1; j < strs.size(); j++)
                {
                    if (strs[0][i] == strs[j][i] || i > strs[j].length())
                        return prefixResult;
                }

                prefixResult += strs[0][i];
            }

            return prefixResult;
        }
};