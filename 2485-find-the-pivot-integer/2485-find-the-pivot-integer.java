class Solution {
    public int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }
        
        Integer leftPointer = 1;
        Integer rightPointer = n;
        
        Integer leftSum = 1;
        Integer rightSum = n;

        while (leftPointer <= rightPointer) {
            
            if (leftSum.equals(rightSum) && leftPointer.equals(rightPointer)) {
                return leftPointer;
            }

            if (leftSum < rightSum) {
                leftPointer++;
                leftSum += leftPointer;
                continue;
            }

            rightPointer--;
            rightSum += rightPointer;
        }
        
        return -1;
    }
}