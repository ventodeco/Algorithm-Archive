class Solution {
    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastOccurred = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccurred.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if (seen.contains(ch)) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch && lastOccurred.get(stack.peek()) > i) {
                seen.remove(stack.pop());
            }

            stack.push(ch);
            seen.add(ch);
        }

        StringBuilder result = new StringBuilder();
        while (! stack.isEmpty()) {
            result.append(stack.pop());
        }

        result.reverse();

        return result.toString();
    }
}