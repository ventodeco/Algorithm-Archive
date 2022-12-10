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
      result.append(root.right.val)

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

if __name__ == '__main__':
  unittest.main()
