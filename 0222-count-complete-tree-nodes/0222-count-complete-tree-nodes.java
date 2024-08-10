/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        Integer result = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (! stack.isEmpty()) {
            TreeNode current = stack.pop();
            result++;
            
            if (current.right != null) {
                stack.add(current.right);
            }
            
            if (current.left != null) {
                stack.add(current.left);
            }
        }
        
        return result;
    }
}