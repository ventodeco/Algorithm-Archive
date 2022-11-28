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
    static int TRUE = 1;
    static int FALSE = 0;
    static int OR = 2;
    static int AND = 3;

    public static boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean leftRoot = checkLeftValue(root);
        boolean rightRoot = checkRightValue(root);

        if (root.left != null) {
            leftRoot = evaluateTree(root.left);
        }

        if (root.right != null) {
            rightRoot = evaluateTree(root.right);
        }

        if (root.val == TRUE) {
            return true;
        } 

        if (root.val == FALSE) {
            return false;
        }

        boolean result = false;

        result = checkOROperand(root, leftRoot, rightRoot, result);

        result = checkANDOperand(root, leftRoot, rightRoot, result);

        return result;
    }

    private static boolean checkLeftValue(TreeNode root) {
        if (root.left != null && root.left.val == TRUE) {
            return true;
        }

        return false;
    }

    private static boolean checkRightValue(TreeNode root) {
        if (root.right != null && root.right.val == TRUE) {
            return true;
        }

        return false;
    }

    private static boolean checkOROperand(TreeNode root, boolean leftRoot, boolean rightRoot, boolean result) {
        if (root.val == OR && (leftRoot || rightRoot)) {
            return true;
        }

        return result;
    }

    private static boolean checkANDOperand(TreeNode root, boolean leftRoot, boolean rightRoot, boolean result) {
        if (root.val == AND && (leftRoot && rightRoot)) {
            return true;
        }

        return result;
    }
}
