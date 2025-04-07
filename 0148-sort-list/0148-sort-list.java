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
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        while (head != null) {
            maxHeap.add(head.val);
            head = head.next;
        }

        ListNode result = null;
        while (!maxHeap.isEmpty()) {
            result = new ListNode(maxHeap.poll(), result);
        }

        return result;
    }
}