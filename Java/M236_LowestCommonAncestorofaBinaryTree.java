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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return searchLCS(root, p, q);
    }
    
    public TreeNode searchLCS(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null || root == p || root == q ) {
            return root;
        } else {
            TreeNode lNode = searchLCS(root.left, p, q);
            TreeNode rNode = searchLCS(root.right, p, q);
            if (lNode != null && rNode != null) {
                return root;
            } else if (lNode != null) {
                return lNode;
            } else if (rNode != null) {
                return rNode;
            } else {
                return null;
            }
        }
    }
}