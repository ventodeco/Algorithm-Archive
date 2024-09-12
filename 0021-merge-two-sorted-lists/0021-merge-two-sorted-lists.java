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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null) {
            return list2;
        }
        
        if (list2 == null) {
            return list1;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        while (list1 != null) {
            minHeap.add(list1.val);
            list1 = list1.next;
        }
        
        while (list2 != null) {
            minHeap.add(list2.val);
            list2 = list2.next;
        }
        
        ListNode head = new ListNode(-101);
        ListNode tail = new ListNode(-101);

        head.next = tail;
        
        ListNode keeper = head;
        ListNode temp;

        while (! minHeap.isEmpty()) {
            temp = new ListNode(minHeap.poll(), tail);
            keeper.next = temp;
            keeper = keeper.next;
        }
        
        keeper.next = null;

        return head.next;
    }
}