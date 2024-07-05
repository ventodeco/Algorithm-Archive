class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()) return false;
        
        int [] f1 = new int [26];
        int [] f2 = new int [26];

        for(int i = 0; i < s1.length();i++)
        {
            f1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s1.length()-1;i++)
        {
            f2[s2.charAt(i)-'a']++;
        }


        if(check(f1, f2)) return true;

        for(int i = s1.length() - 1, j=0;i<s2.length();i++,j++)
        {
            f2[s2.charAt(i)-'a']++;
            if(check(f1,f2)) return true;
            f2[s2.charAt(j)-'a']--;
        }
        return false;
    }
    
    public static boolean check(int []f1,int[] f2)
    {
        for(int i = 0; i < 26; i++)
        {
            if (f1[i] != f2[i]) return false;
        }
        return true;
    }
}