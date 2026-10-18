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
    private int heightDiff = 0;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        helper(root);
        return heightDiff>1?false:true;

    }
    private int helper(TreeNode root){
        if(root==null)
            return 0;
        int ld = helper(root.left);
        int rd = helper(root.right);
        heightDiff = Math.max(heightDiff,Math.abs(ld-rd));
        return Math.max(ld,rd)+1;

    }
}
