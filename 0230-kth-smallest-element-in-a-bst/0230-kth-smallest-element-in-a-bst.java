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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        dfs(root, minHeap);

        int iterator = 1;
        while (! minHeap.isEmpty()) {
            if (k == iterator) {
                return minHeap.poll();
            }
            minHeap.poll();
            iterator++;
        }

        return -1;
    }
    
    private void dfs(TreeNode root, PriorityQueue<Integer> minHeap) {
        
        if (root == null) {
            return;
        }
        
        minHeap.add(root.val);
        
        if (root.right != null) {
            dfs(root.right, minHeap);
        }
        
        if (root.left != null) {
            dfs(root.left, minHeap);
        }
        
        return;
    }
}