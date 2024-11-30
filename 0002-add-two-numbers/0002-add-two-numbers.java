import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String number1 = "";
        String number2 = "";

        while (l1 != null) {
            number1 = String.valueOf(l1.val) + number1;
            l1 = l1.next;
        }

        while (l2 != null) {
            number2 = String.valueOf(l2.val) + number2;
            l2 = l2.next;
        }

        String resultInString = new BigInteger(number1).add(new BigInteger(number2)).toString();

        ListNode result = null;
        for (int i = 0; i < resultInString.length(); i++) {
            result = new ListNode(resultInString.charAt(i) - '0', result);
        }

        return result;
    }
}