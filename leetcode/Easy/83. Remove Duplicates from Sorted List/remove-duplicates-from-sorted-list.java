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
  public ListNode checkIsSame(ListNode currentNode, ListNode nextNode) {
      if (nextNode == null) {
          return currentNode;
      }

      while (currentNode.val == nextNode.val) {
          currentNode.next = nextNode.next;
          nextNode = currentNode.next;

          if (nextNode == null) {
              return currentNode;
          }
      }

      return currentNode;
  }

  public ListNode deleteDuplicates(ListNode head) {
      ListNode node = head;

      while(node != null) {
          node = checkIsSame(node, node.next);
          node = node.next;
      }

      return head;
  }
}














