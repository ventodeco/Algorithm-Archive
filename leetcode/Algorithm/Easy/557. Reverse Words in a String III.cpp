class Solution {
public:
    vector<string> splitToWord(string s) {

        vector<string> result;

        string word = "";

        for (auto item: s) {
            if (item == ' ') {
                result.push_back(word);
                word = "";
            } else {
                word += item;
            }
        }
        result.push_back(word);

        return result;
    }

    string reverseWords(string s) {
        vector<string> _vec;

        _vec = splitToWord(s);

        string result = "";

        for (int i = 0; i < _vec.size(); i++) {
            reverse(_vec[i].begin(), _vec[i].end());

            result += _vec[i];

            if (i < _vec.size() - 1) 
                result += " ";
        }

        return result;
    }
};