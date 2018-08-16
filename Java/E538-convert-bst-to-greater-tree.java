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
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode p = root;
        int sum = 0;
        while(!stack.isEmpty() || p != null){
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                TreeNode node = stack.pop();
                int presum = sum;
                sum += node.val;
                node.val += presum;
                p = node.left;
            }
        }
        return root;
    }
}