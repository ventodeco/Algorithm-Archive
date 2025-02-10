class Solution {
    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        
        int[] arr = new int[n];
        arr[n - 1] = 1;
        arr[n - 2] = 2;
        for (int i = n - 3; i >= 0; i--) {
            arr[i] = arr[i + 1] + arr[i + 2];
        }

        return arr[0];
    }
}