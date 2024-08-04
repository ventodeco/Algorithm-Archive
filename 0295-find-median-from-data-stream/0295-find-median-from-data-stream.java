class MedianFinder {
    
    PriorityQueue<Integer> leftSideKeeper;
    PriorityQueue<Integer> rightSideKeeper;

    public MedianFinder() {
        rightSideKeeper = new PriorityQueue<>();
        leftSideKeeper = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (leftSideKeeper.isEmpty()) {
            leftSideKeeper.add(num);   
        } else if (leftSideKeeper.peek() < num && rightSideKeeper.isEmpty()) {
            rightSideKeeper.add(num);
        } else if (! rightSideKeeper.isEmpty() && rightSideKeeper.peek() < num) {
            rightSideKeeper.add(num);
        } else {
            leftSideKeeper.add(num);   
        }
    }

    public double findMedian() {

        while (leftSideKeeper.size() > rightSideKeeper.size()) {
            rightSideKeeper.add(leftSideKeeper.poll());
        }
        
        while (leftSideKeeper.size() < rightSideKeeper.size()) {
            leftSideKeeper.add(rightSideKeeper.poll());
        }
        
        if (leftSideKeeper.size() == rightSideKeeper.size()) {
            return (double) (leftSideKeeper.peek() + rightSideKeeper.peek()) / 2;
        } else if (leftSideKeeper.size() > rightSideKeeper.size()) {
            return (double) leftSideKeeper.peek();
        }
        
        return (double) rightSideKeeper.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */