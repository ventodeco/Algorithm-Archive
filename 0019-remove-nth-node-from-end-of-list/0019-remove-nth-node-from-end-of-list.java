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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode keeper = head;
        Integer indexSize = 0;

        while (keeper != null) {
            keeper = keeper.next;
            
            indexSize++;
        }

        if (indexSize == n) {
            return head.next;
        }

        keeper = head;
        for (int i = 1; i < indexSize - n; i++) {
            keeper = keeper.next;
        }

        if (keeper.next != null) {
            keeper.next = keeper.next.next;
        }
        
        return head;
    }
}