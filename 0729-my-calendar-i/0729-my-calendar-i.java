class MyCalendar {

    private SortedSet<int[]> sortedSet;
    
    public MyCalendar() {
        sortedSet = new TreeSet<>((a, b) -> a[0] - b[0]);
    }

    public boolean book(int start, int end) {

        boolean isEligible = true;
        for (int[] entry : sortedSet) {
            if (end <= entry[0]) {
                break;
            }

            if (
                (entry[0] <= start && start < entry[1]) || 
                (entry[0] <= end && end <= entry[1]) || 
                (start <= entry[0] && entry[1] <= end)
            ) {
                isEligible = false;
                break;
            }
        }

        if (isEligible) {
            sortedSet.add(new int[]{start, end});
        }

        return isEligible;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */