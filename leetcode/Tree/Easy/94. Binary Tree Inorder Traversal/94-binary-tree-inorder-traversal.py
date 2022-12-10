import unittest

class TreeNode(object):
  def __init__(self, val=0, left=None, right=None):
    self.val = val
    self.left = left
    self.right = right

class Solution(object):
  def inorderTraversal(self, root):
    """
    :type root: TreeNode
    :rtype: List[int]
    """
    return []

class TestCase(unittest.TestCase):
  def testWithEmptyTree(self):
    self.assertEqual(Solution.inorderTraversal(Solution(), None), [], "failed")

if __name__ == '__main__':
  unittest.main()
