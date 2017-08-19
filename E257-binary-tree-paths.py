# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        if not root:
            return []
        res = []
        self.DFSTraverseNode(root, '', res)
        return res
    def DFSTraverseNode(self, root, traverse, res):
        if root.left:
            self.DFSTraverseNode(root.left, traverse + str(root.val) + '->',res)
        if root.right:
            self.DFSTraverseNode(root.right,traverse + str(root.val) + '->', res)
        if not root.left and not root.right:
            res.append(traverse + str(root.val))           