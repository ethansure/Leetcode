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
    public int maxDepth(TreeNode root) {
        return deep(root,1);
    }
    
    public int deep(TreeNode node, int depth){
        if (node == null) {
            return depth - 1;
        } else {
            int ld = deep(node.left, depth + 1);
            int rd = deep(node.right, depth + 1);
            return ld > rd? ld: rd;
        }
    }
}