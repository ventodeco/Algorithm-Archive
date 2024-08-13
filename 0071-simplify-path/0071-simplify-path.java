class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] pathArray = path.split("/");
        
        for (int i = 0; i < pathArray.length; i++) {
            
            if (pathArray[i].equals("") || pathArray[i].equals(".")) {
                continue;
            }

            if (pathArray[i].equals("..")) {
                if (! stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(pathArray[i]);
            }
        }

        String result = "/";
        for (int i = 0; i < stack.size(); i++) {
            result += stack.get(i);
            if (i < stack.size() - 1) {
                result += "/";
            }
        }
        
        return result;
    }
}