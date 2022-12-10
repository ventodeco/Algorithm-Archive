import unittest

class TreeNode(object):
  def __init__(self, val=0, left=None, right=None):
    self.val = val
    self.left = left
    self.right = right

class Solution(object):
  def inorderTraversal(self, root):
    result = []

    if root.val == 0:
      return []

    if root.left:
      result.extend(self.inorderTraversal(root.left))

    result.append(root.val)

    if root.right:
      result.extend(self.inorderTraversal(root.right))

    return result

class TestCase(unittest.TestCase):
  def testWithEmptyTree(self):
    self.assertEqual(Solution.inorderTraversal(Solution(), None), [], "failed")

  def testWithOneNode(self):
    root = TreeNode(2)

    self.assertEqual(Solution.inorderTraversal(Solution(), root), [2], "failed")

  def testHaveLeftLeafOnly(self):
    leftLeaf = TreeNode(1)
    root = TreeNode(2, leftLeaf)

    self.assertEqual(Solution.inorderTraversal(Solution(), root), [1, 2], "failed")

  def testHaveLeftAndRightLeaf(self):
    leftLeaf = TreeNode(10)
    rightLeaf = TreeNode(1)
    root = TreeNode(2, leftLeaf, rightLeaf)

    self.assertEqual(Solution.inorderTraversal(Solution(), root), [10, 2, 1], "failed")

  def testHaveLeftChildInLeftLeaf(self):
    leftChildLeftLeaf = TreeNode(10)

    leftLeaf = TreeNode(5, leftChildLeftLeaf, None)
    rightLeaf = TreeNode(8)

    root = TreeNode(4, leftLeaf, rightLeaf)

    self.assertEqual(Solution.inorderTraversal(Solution(), root), [10, 5, 4, 8], "failed")

  def testHaveLeftAndRightChildInLeftLeaf(self):
    leftChildLeftLeaf = TreeNode(10)
    rightChildLeftLeaf = TreeNode(11)

    leftLeaf = TreeNode(5, leftChildLeftLeaf, rightChildLeftLeaf)
    rightLeaf = TreeNode(8)

    root = TreeNode(4, leftLeaf, rightLeaf)

    self.assertEqual(Solution.inorderTraversal(Solution(), root), [10, 5, 11, 4, 8], "failed")

  def testHaveLeftChildInRightLeaf(self):
    leftChildLeftLeaf = TreeNode(10)

    leftLeaf = TreeNode(8)
    rightLeaf = TreeNode(5, leftChildLeftLeaf)

    root = TreeNode(4, leftLeaf, rightLeaf)

    self.assertEqual(Solution.inorderTraversal(Solution(), root), [8, 4, 10, 5], "failed")

  def testHaveLeftRightChildInRightLeaf(self):
    leftChildLeftLeaf = TreeNode(10)
    rightChildLeftLeaf = TreeNode(9)

    leftLeaf = TreeNode(8)
    rightLeaf = TreeNode(5, leftChildLeftLeaf, rightChildLeftLeaf)

    root = TreeNode(4, leftLeaf, rightLeaf)

    self.assertEqual(Solution.inorderTraversal(Solution(), root), [8, 4, 10, 5, 9], "failed")

if __name__ == '__main__':
  unittest.main()
