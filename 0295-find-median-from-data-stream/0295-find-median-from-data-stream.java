class MedianFinder {

    PriorityQueue<Integer> leftSide;
    PriorityQueue<Integer> rightSide;

    public MedianFinder() {
        leftSide = new PriorityQueue<>((a, b) -> b - a);
        rightSide = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (leftSide.isEmpty()) {
            leftSide.add(num);
            return;
        }

        if (leftSide.peek() < num && rightSide.isEmpty()) {
            rightSide.add(num);
            return;
        }

        if (leftSide.peek() > num) {
            leftSide.add(num);
            return;
        }

        rightSide.add(num);
    }

    public double findMedian() {
        
        while (rightSide.size() < leftSide.size()) {
            rightSide.add(leftSide.poll());
        }

        while (leftSide.size() < rightSide.size()) {
            leftSide.add(rightSide.poll());
        }

        if (leftSide.size() != rightSide.size()) {
            return (double) leftSide.peek();
        }
        System.out.println("tes" + leftSide.peek() + " " + rightSide.peek());
        return (double) (leftSide.peek() + rightSide.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */