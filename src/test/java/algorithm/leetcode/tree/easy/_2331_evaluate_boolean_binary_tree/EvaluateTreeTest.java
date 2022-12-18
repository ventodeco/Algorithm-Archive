package algorithm.leetcode.tree.easy._2331_evaluate_boolean_binary_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import algorithm.leetcode.tree.TreeNode;

public class EvaluateTreeTest {
  @Test
  @DisplayName("test evaluation tree empty should return false")
  void testEvaluationTree_rootEmpty() {
    TreeNode tree = TreeNode.newTree();

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node should return true")
  void testEvaluationTree_rootWithOnlyOneNode_returnTrue() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.TRUE);

    assertEquals(true, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node should return false")
  void testEvaluationTree_rootWithOnlyOneNode_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.FALSE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node (OR) has one leaf left false should return false")
  void testEvaluationTree_rootWithOnlyOneNodeOR_hasOneLeafLeftFalse_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.OR, EvaluateTree.FALSE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node (OR) has one leaf left true should return true")
  void testEvaluationTree_rootWithOnlyOneNodeOR_hasOneLeafLeftTrue_returnTrue() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.OR, EvaluateTree.TRUE);

    assertEquals(true, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node (OR) has one leaf right false should return false")
  void testEvaluationTree_rootWithOnlyOneNodeOR_hasOneLeafRightFalse_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.OR, null, EvaluateTree.FALSE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node (OR) has one leaf right true should return true")
  void testEvaluationTree_rootWithOnlyOneNodeOR_hasOneLeafRightTrue_returnTrue() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.OR, null, EvaluateTree.TRUE);

    assertEquals(true, EvaluateTree.evaluateTree(tree));
  }
}
