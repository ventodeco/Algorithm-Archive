class Solution {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return countDepth(root, 1);
    }

    private int countDepth(TreeNode root, int counter) {

        if (root == null || (root.right == null && root.left == null)) {
            return counter;
        }

        return Math.max(countDepth(root.right, counter + 1), countDepth(root.left, counter + 1));
    }
}