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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        rowLargestValues(root, res, 1);
        return res;
    }
    
    public void rowLargestValues(TreeNode root, List<Integer> res, int level) {
        if ( root == null ) {
            return;
        }
        
        if (res.size() < level) {
            res.add(root.val);
        } else {
            res.set(level - 1, Math.max(res.get(level - 1), root.val));
        }
        
        rowLargestValues(root.left, res, level + 1);
        rowLargestValues(root.right, res, level + 1);
    }
}