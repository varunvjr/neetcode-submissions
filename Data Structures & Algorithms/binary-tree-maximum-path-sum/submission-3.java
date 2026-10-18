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
    private int res[];
    public int maxPathSum(TreeNode root) {
        res = new int[1];
        res[0] = Integer.MIN_VALUE;
        helper(root);
        return res[0];
    }
    private int helper(TreeNode root){
        if(root == null)
            return 0;
        int ld = helper(root.left);
        int rd = helper(root.right);
        ld = Math.max(ld,0);
        rd = Math.max(rd,0);
        res[0] = Math.max(res[0],ld+rd+root.val);
        return Math.max(ld,rd)+root.val;
    }
}
