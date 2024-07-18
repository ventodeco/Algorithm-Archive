class Solution {
    public String reverseWords(String s) {
        List<String> strList = new ArrayList<>();
        
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                str += s.charAt(i);
            }

            if (s.charAt(i) == ' ' && !str.isEmpty()) {
                strList.add(str);
                str = "";
            }
        }
        
        if (!str.isEmpty()) {
            strList.add(str);
        }
        
        String result = "";
        for (int i = strList.size() - 1; i >= 0; i--) {
            if (i == strList.size() - 1) {
                result += strList.get(i);
            } else {
                result += " " + strList.get(i);
            }
        }
        
        return result;
    }
}