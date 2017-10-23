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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        addLevelNodes(root, 1, l);
        for(int i = 0; i < l.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(l.get(i));
            }
        }
        return l;
    }
    
    public void addLevelNodes(TreeNode node, int level, List<List<Integer>> l) {
        if (node == null) return;
        if (level <= l.size()) {
            l.get(level - 1).add(node.val);   
        } 
        if (level > l.size()) {
            List<Integer> nl = new ArrayList<Integer>();
            nl.add(node.val);
            l.add(nl);
        } 
        addLevelNodes(node.left, level + 1, l);
        addLevelNodes(node.right, level + 1, l);
    }
}