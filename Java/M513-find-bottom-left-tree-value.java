/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        int bottomLeft = 0;
        stack.add(root);
        while(!stack.isEmpty()) {
            bottomLeft = stack.peek().val;
            int size = stack.size();
            for(int i = 0; i < size; ++i) {
                TreeNode tn = stack.pop();
                if (tn.left != null) stack.add(tn.left);
                if (tn.right != null) stack.add(tn.right);
            }
        }
        return bottomLeft;        
    }
}