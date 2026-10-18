/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return helper(root);
    }
    private int helper(TreeNode n){
        if(n==null){
            return 0;
        }
        int ld = helper(n.left);
        int rd = helper(n.right);
        return Math.max(ld,rd)+1;
    }
}
