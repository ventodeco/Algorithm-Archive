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
    public List<Integer> postorderTraversal(TreeNode root) {
        return getPostOrderTraversal(root, new ArrayList<>());
    }
    
    private List<Integer> getPostOrderTraversal(TreeNode root, List<Integer> result) {
        
        if (root == null) {
            return result;
        }

        if (root.left != null) {
            result = getPostOrderTraversal(root.left, result);
        }
        
        if (root.right != null) {
            result = getPostOrderTraversal(root.right, result);
        }
        
        result.add(root.val);

        return result;
    }
}