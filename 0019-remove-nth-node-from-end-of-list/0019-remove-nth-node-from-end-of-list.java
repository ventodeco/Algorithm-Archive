class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (n == size) {
            return head.next;
        }

        temp = head;
        for (int i = 1; i < size - n; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}
