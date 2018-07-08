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
  public TreeNode constructMaximumBinaryTree(int[] nums) {
      TreeNode root = null;
      for (int num:nums) {
          TreeNode node = new TreeNode(num);
          if (root == null) {
              root = node;
          } else {
              TreeNode cur = root;
              TreeNode pre = null;
              while(cur != null) {
                  if (node.val < cur.val) {
                      pre = cur;
                      cur = cur.right;
                  } else if (node.val > cur.val) {
                      node.left = cur;
                      break;
                  }
              }
              if (pre != null) {
                  pre.right = node;
              } else {
                  root = node;
              }
          }
      }
      return root;
  }
}