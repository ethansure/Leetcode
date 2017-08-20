# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        ns = []
        self.traverse(root, ns)
        return ','.join(ns)
        
    def traverse(self, node, ns):
        if not node:
            ns.append('None')
        else:
            ns.append(str(node.val))
            self.traverse(node.left, ns)
            self.traverse(node.right, ns)
    
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        ns = data.split(',')
        return self.buildNode(ns)
    
    def buildNode(self, ns):
        try:
            val = ns.pop(0)
            if val == 'None':
                return None
            n = TreeNode(int(val))
            n.left = self.buildNode(ns)
            n.right = self.buildNode(ns)
            return n
        except:
            return None
# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))