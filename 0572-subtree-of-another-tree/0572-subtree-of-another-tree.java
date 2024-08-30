class Solution {
    
    private TreeNode temp;
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if (root == null) {
            return false;
        }
        
        if (isSameTree(root, subRoot)) {
            return true;
        }
        
        return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        
        if (root == null && subRoot == null) {
            return true;
        }
        
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        
        return isSameTree(root.right, subRoot.right) && isSameTree(root.left, subRoot.left);
    }
}