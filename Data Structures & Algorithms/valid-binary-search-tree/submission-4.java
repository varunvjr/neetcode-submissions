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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean helper(TreeNode node,int left,int right){
        if(node==null)
            return true;
        if((left!=Integer.MIN_VALUE&&node.val<=left)||(right!=Integer.MAX_VALUE&&node.val>=right))
            return false;
        return helper(node.left,left,node.val)&&helper(node.right,node.val,right);
    }
}
