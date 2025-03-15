class Solution {
    public int romanToInt(String s) {
        
        int result = 0;
        int checkNext;
        int val;

        // IV: 5-1

        for (int i = 0; i < s.length(); i++) {

            val = convert(s.charAt(i));

            if (i != s.length() - 1) {
                checkNext = convert(s.charAt(i + 1));
                if (checkNext > val) {
                    val = checkNext - val;
                    i++;
                }
            }

            result += val;
        }

        return result;
    }

    private Integer convert(Character ch) {

        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
        }

        throw new RuntimeException("Character is not valid");
    }
}