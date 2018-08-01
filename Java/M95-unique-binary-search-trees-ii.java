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
  public List<TreeNode> generateTrees(int n) {
      List<TreeNode> res = new ArrayList<>(); 
      if (n < 1) {
          return res;
      }
      res = enumerate(1, n);
      return res;
  }
  
  public List<TreeNode> enumerate(int low, int high) {
      
      List<TreeNode> res = new ArrayList<>();
      
      if (low > high) {
          res.add(null);
          return res;
      }
      
      if (low == high) {
          TreeNode n = new TreeNode(low);
          res.add(n);
          return res;
      }
      
      List<TreeNode> left = new ArrayList<>();
      List<TreeNode> right = new ArrayList<>();
      for(int i = low; i <= high; i++) {
          left = enumerate(low, i - 1);
          right = enumerate(i + 1, high);
          
          for(TreeNode ln:left) {
              for(TreeNode rn:right) {
                  TreeNode n = new TreeNode(i);
                  n.left = ln;
                  n.right = rn;
                  res.add(n);
              }
          }
      }
      
      return res;
  }
}