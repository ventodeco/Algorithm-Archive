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
    
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public TreeNode increasingBST(TreeNode root) {
        getData(root);
        
        TreeNode head = new TreeNode();
        TreeNode temp = head;
        while (! minHeap.isEmpty()) {
            temp.val = minHeap.poll();
            
            if (! minHeap.isEmpty()) {
                temp.right = new TreeNode();
                temp = temp.right;
            }
        }

        return head;
    }
    
    private void getData(TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        minHeap.add(root.val);
        
        if (root.left != null) {
            getData(root.left);
        }
        
        if (root.right != null) {
            getData(root.right);
        }
        
        return;
    }
}