class Solution {
    public int reverse(int x) {
        
        String str = String.valueOf(x);
        
        String result = "";

        Integer iterator = 0;
        if (str.charAt(0) == '-') {
            result += str.charAt(0);
            iterator = 1;
        }

        for (int i = str.length() - 1; i >= iterator; i--) {
            
            result += str.charAt(i);
        } 
        
        try {
            return Integer.parseInt(result);   
        } catch (Exception e) {
            return 0;
        }
    }
}