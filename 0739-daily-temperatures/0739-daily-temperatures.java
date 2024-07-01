class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int res[] = new int[n];
        for(int i = 0; i < n; i++) {
            int currTemp = temperatures[i];
            while(!s.isEmpty() && temperatures[s.peek()] < currTemp){
                int k = s.pop();
                res[k] = i - k;
            }
            s.push(i);
        }

        return res;
    }
}