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
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root, 0);
    }

    private int getMaxDepth(TreeNode node, int height) {
        if (node == null) {
            return height;
        }

        height++;

        int left = height;
        if (node.left != null) {
            left = getMaxDepth(node.left, height);
        }

        int right = height;
        if (node.right != null) {
            right = getMaxDepth(node.right, height);
        }

        return Math.max(left, right);
    }
}