class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp;
        ListNode pointer;
        ListNode result = null;
        pointer = result;
        int valueL1 = 0;
        int valueL2 = 0;
        int resultSum;
        int carryOver = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                valueL1 = carryOver + l1.val;
                carryOver = 0;
                l1 = l1.next;
            } 

            if (l2 != null) {
                valueL2 = carryOver + l2.val;
                carryOver = 0;
                l2 = l2.next;
            }

            resultSum = valueL1 + valueL2;
            valueL1 = 0;
            valueL2 = 0;
            while (resultSum >= 10) {
                resultSum -= 10;
                carryOver += 1;
            }

            temp = new ListNode(resultSum);

            if (result == null) {
                result = temp;
                pointer = result;
            } else {
                pointer.next = temp;
                pointer = temp;
            }
        }

        if (carryOver > 0) {
            temp = new ListNode(carryOver);

            if (result == null) {
                result = temp;
                pointer = result;
            } else {
                pointer.next = temp;
                pointer = temp;
            }
        }

        return result;
    }
}