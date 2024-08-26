class Solution {
    public int maxDepth(TreeNode root) {
        return countDepth(root, 0);
    }

    private int countDepth(TreeNode root, int count) {
        
        if (root == null) {
            return count;
        }
        
        count++;
        
        return Math.max(countDepth(root.right, count), countDepth(root.left, count));
    }
}