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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (ListNode list : lists) {
            while (list != null) {
                maxHeap.add(list.val);
                list = list.next;
            }
        }

        ListNode result = null;
        while (!maxHeap.isEmpty()) {
            result = new ListNode(maxHeap.poll(), result);
        }

        return result;
    }
}