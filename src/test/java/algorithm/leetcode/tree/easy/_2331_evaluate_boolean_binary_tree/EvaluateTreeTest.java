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

  @Test
  @DisplayName("evaluation tree with one node (AND) has one leaf left false should return false")
  void testEvaluationTree_rootWithOnlyOneNodeAND_hasOneLeafLeftFalse_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.AND, EvaluateTree.FALSE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node (AND) has one leaf left true should return false")
  void testEvaluationTree_rootWithOnlyOneNodeAND_hasOneLeafLeftTrue_returnTrue() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.AND, EvaluateTree.TRUE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node (AND) has one leaf right false should return false")
  void testEvaluationTree_rootWithOnlyOneNodeAND_hasOneLeafRightFalse_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.AND, null, EvaluateTree.FALSE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node (AND) has one leaf right true should return false")
  void testEvaluationTree_rootWithOnlyOneNodeAND_hasOneLeafRightTrue_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.AND, null, EvaluateTree.TRUE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node (OR) has two leaf should return false")
  void testEvaluationTree_rootWithOnlyOneNodeOR_hasTwoLeaf_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.OR, EvaluateTree.FALSE, EvaluateTree.FALSE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node (OR) has two leaf should return true")
  void testEvaluationTree_rootWithOnlyOneNodeOR_hasTwoLeaf_returnTrue() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.OR, EvaluateTree.FALSE, EvaluateTree.TRUE);

    assertEquals(true, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node (AND) has two leaf should return false")
  void testEvaluationTree_rootWithOnlyOneNodeAND_hasTwoLeaf_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.AND, EvaluateTree.FALSE, EvaluateTree.FALSE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree with one node (AND) has two leaf should return true")
  void testEvaluationTree_rootWithOnlyOneNodeAND_hasTwoLeaf_returnTrue() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.AND, EvaluateTree.TRUE, EvaluateTree.TRUE);

    assertEquals(true, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree has child in left (OR) value should return false")
  void testEvaluationTree_hasChildInLeftWithOR_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.OR, EvaluateTree.OR, EvaluateTree.FALSE, EvaluateTree.FALSE, EvaluateTree.FALSE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree has child in left (OR) value should return true")
  void testEvaluationTree_hasChildInLeftWithOR_returnTrue() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.OR, EvaluateTree.OR, EvaluateTree.TRUE, EvaluateTree.TRUE, EvaluateTree.TRUE);

    assertEquals(true, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree has child in right (OR) value should return false")
  void testEvaluationTree_hasChildInRightWithOR_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.OR, EvaluateTree.FALSE, EvaluateTree.OR, null, null, EvaluateTree.FALSE, EvaluateTree.FALSE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree has child in right (OR) value should return true")
  void testEvaluationTree_hasChildInRightWithOR_returnTrue() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.OR, EvaluateTree.FALSE, EvaluateTree.OR, null, null, EvaluateTree.FALSE, EvaluateTree.TRUE);

    assertEquals(true, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree has child in left (AND) value should return false")
  void testEvaluationTree_hasChildInLeftWithAND_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.AND, EvaluateTree.AND, EvaluateTree.FALSE, EvaluateTree.TRUE, EvaluateTree.TRUE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree has child in left (AND) value should return true")
  void testEvaluationTree_hasChildInLeftWithAND_returnTrue() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.AND, EvaluateTree.AND, EvaluateTree.TRUE, EvaluateTree.TRUE, EvaluateTree.TRUE);

    assertEquals(true, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree has child in right (AND) value should return false")
  void testEvaluationTree_hasChildInRightWithAND_returnFalse() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.AND, EvaluateTree.FALSE, EvaluateTree.AND, null, null, EvaluateTree.FALSE, EvaluateTree.FALSE);

    assertEquals(false, EvaluateTree.evaluateTree(tree));
  }

  @Test
  @DisplayName("evaluation tree has child in right (AND) value should return true")
  void testEvaluationTree_hasChildInRightWithAND_returnTrue() {
    TreeNode tree = TreeNode.newTree(EvaluateTree.AND, EvaluateTree.TRUE, EvaluateTree.AND, null, null, EvaluateTree.TRUE, EvaluateTree.TRUE);

    assertEquals(true, EvaluateTree.evaluateTree(tree));
  }
}
