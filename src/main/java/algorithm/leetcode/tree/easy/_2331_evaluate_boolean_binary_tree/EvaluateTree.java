package algorithm.leetcode.tree.easy._2331_evaluate_boolean_binary_tree;

import algorithm.leetcode.tree.TreeNode;

public class EvaluateTree {
  public static int TRUE = 1;
  public static int FALSE = 0;
  public static int OR = 2;
  public static int AND = 3;

  public static boolean evaluateTree(TreeNode root) {
    if (root == null) {
      return false;
    }

    if (root.val == FALSE) {
      return false;
    }

    if (root.val == OR) {
      return evaluateTree(root.left) || evaluateTree(root.right);
    }

    if (root.val == AND) {
      return false;
    }

    return true;
  }
}
