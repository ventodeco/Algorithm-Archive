class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        
        int[] result = new int[temperatures.length];
        int tempValue;
        for (int i = temperatures.length - 1; i >= 0; i--) {

            tempValue = 0;
            while (! stack.isEmpty()) {
                int[] tempArr = stack.peek();
                if (temperatures[i] >= tempArr[0]) {
                    stack.pop();
                } else {
                    tempValue = tempArr[1] - i;
                    break;
                }
            }
            stack.add(new int[]{temperatures[i], i});

            result[i] = tempValue;
        }

        return result;
    }
}