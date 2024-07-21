class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] asciiCounterS = new int[256];
        int[] asciiCounterT = new int[256];

        for(int i = 0; i < s.length(); i++) {
            if(asciiCounterS[s.charAt(i)] != asciiCounterT[t.charAt(i)]) {
                return false;
            }

            asciiCounterS[s.charAt(i)] = i + 1;
            asciiCounterT[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
