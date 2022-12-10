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
      result.append(root.left.val)

    result.append(root.val)

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

if __name__ == '__main__':
  unittest.main()
