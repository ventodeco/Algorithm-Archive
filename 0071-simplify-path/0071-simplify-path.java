class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] strArr = path.split("/");

        for (int i = 0; i < strArr.length; i++) {

            if (strArr[i].equals(".")) {
                continue;
            }

            if (strArr[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            if (strArr[i] == null || strArr[i].equals("") || strArr[i].equals("/")) {
                continue;
            }

            stack.push(strArr[i]);
        }

        String result = "/";

        for (int i = 0; i < stack.size(); i++) {
            String temp = stack.get(i);

            if (temp == null || temp.equals("") || temp.equals("/")) {
                continue;
            }

            result += temp;

            if (i != stack.size() - 1) {
                result += "/";
            }
        }

        return result;
    }
}