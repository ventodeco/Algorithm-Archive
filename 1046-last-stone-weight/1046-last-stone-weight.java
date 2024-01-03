class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> stonesMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            stonesMaxHeap.add(stones[i]);
        }

        int firstStone;
        int secondStone;

        while (stonesMaxHeap.size() > 1) {
           firstStone = stonesMaxHeap.poll();
           secondStone = stonesMaxHeap.poll();

           if (firstStone == secondStone) {
               continue;
           }

           stonesMaxHeap.add(Math.abs(firstStone - secondStone));
        }

        if (stonesMaxHeap.size() == 0) {
            return 0;
        }

        return stonesMaxHeap.peek();
    }
}