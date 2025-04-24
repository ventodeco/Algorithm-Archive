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

        if (list1 == null && list2 == null) {
            return null;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        while (list1 != null) {
            maxHeap.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            maxHeap.add(list2.val);
            list2 = list2.next;
        }

        ListNode result = new ListNode(maxHeap.poll());

        while (!maxHeap.isEmpty()) {
            result = new ListNode(maxHeap.poll(), result);
        }

        return result;
    }
}