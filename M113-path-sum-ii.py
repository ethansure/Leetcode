# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        allPath = []
        self.getPath(root, sum, [], allPath)
        return allPath
        
        
    def getPath(self, root, sum, path, allPath):
        if not root:
            return;
        if sum - root.val == 0 and not root.left and not root.right:
            allPath.append(path + [root.val])
        else:
            self.getPath(root.left, sum - root.val, path + [root.val], allPath)
            self.getPath(root.right, sum - root.val, path + [root.val], allPath)
        
        
        