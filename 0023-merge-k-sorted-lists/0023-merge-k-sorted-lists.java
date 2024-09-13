class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        ListNode temp;
        for (int i = 0; i < lists.length; i++) {
            
            temp = lists[i];
            
            while (temp != null) {
                maxHeap.add(temp.val);
                temp = temp.next;
            }
        }
        
        ListNode head = null;
        while (! maxHeap.isEmpty()) {
            head = new ListNode(maxHeap.poll(), head);
        }

        return head;
    }
}