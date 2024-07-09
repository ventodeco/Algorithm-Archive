/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        getAllNodesInFlatten(head);
        return head;
    }

    private Node getAllNodesInFlatten(Node head) {
        
        Node current = head;
        Node last = head;

        while (current != null) {

            if (current.child != null) {

                Node subTail = getAllNodesInFlatten(current.child);

                Node next = current.next;
                if (next != null) {
                    subTail.next = next;
                    next.prev = subTail;   
                }

                current.next = current.child;
                current.child.prev = current;

                current.child = null;

                current = subTail;
            }

            last = current;
            current = current.next;
        }
        return last;
    }
}