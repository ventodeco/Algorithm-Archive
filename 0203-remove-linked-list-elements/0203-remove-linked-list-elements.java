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
    public ListNode removeElements(ListNode head, int val) {

        ListNode result = null;
        ListNode headKeeper = null;
        ListNode temp;
        while (head != null) {
            
            if (head.val != val) {
                temp = new ListNode(head.val);
                if (result == null) {
                    result = temp;
                    headKeeper = temp;
                } else {
                    result.next = temp;
                    result = temp;
                }
            }
            
            head = head.next;
        }
        
        return headKeeper;
    }
}