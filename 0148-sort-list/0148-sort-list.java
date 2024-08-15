/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        if (head == null) {
            return null;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while (head != null) {
            minHeap.add(head.val);
            head = head.next;
        }
        
        ListNode result = new ListNode();
        ListNode iterator = result;
        ListNode temp;
        while (! minHeap.isEmpty()) {
            iterator.val = minHeap.poll();

            if (! minHeap.isEmpty()) {
                temp = new ListNode();
                iterator.next = temp;
                iterator = iterator.next;
            }
        }
        
        return result;
    }
}