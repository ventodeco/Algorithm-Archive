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
    public ListNode swapPairs(ListNode head) {
        
        ListNode tempNode;
        ListNode node = head;
        
        if (head == null || head.next == null) {
            return head;
        }
        
        if (node.next != null) {
            head = node.next;
        }

        ListNode prevNode = null;
        while (node != null) {
            tempNode = node.next;
            
            if (node.next == null) {
                break;
            }

            node.next = node.next.next;
            tempNode.next = node;
            
            if (prevNode != null) {
                prevNode.next = tempNode;
            }

            prevNode = node;
            node = node.next;  
        }
        
        return head;
    }
}