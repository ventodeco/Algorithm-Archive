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
    
    private TreeNode temp;
    
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        
        return root;
    }
    
    private void invert(TreeNode root) {
        
        if (root == null) {
            return;
        }

        if (root.left != null && root.right != null) {
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        } else if (root.left != null) {
            root.right = root.left;
            root.left = null;
        } else {
            root.left = root.right;
            root.right = null;
        }

        if (root.left != null) {
            invert(root.left);
        }

        if (root.right != null) {
            invert(root.right);
        }

        return;
    }
}