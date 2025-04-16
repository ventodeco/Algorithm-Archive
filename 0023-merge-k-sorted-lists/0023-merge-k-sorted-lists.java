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

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                maxHeap.add(node.val);
                node = node.next;
            }
        }

        if (maxHeap.isEmpty()) {
            return null;
        }

        ListNode result = new ListNode(maxHeap.poll(), null);
        while (!maxHeap.isEmpty()) {
            result = new ListNode(maxHeap.poll(), result);
        }

        return result;
    }
}