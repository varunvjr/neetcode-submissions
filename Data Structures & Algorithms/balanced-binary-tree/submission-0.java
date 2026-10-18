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
    public boolean isBalanced(TreeNode root) {
        int height[] = new int[1];
        dfs(root,height);
        if(height[0]<=1){
            return true;
        }
        return false;
    }
    public int dfs(TreeNode root,int height[]){
        if(root==null)
            return 0;
        int ld = dfs(root.left,height);
        int rd = dfs(root.right,height);
        height[0] = Math.max(height[0],Math.abs(ld-rd));
        return Math.max(ld,rd)+1;
    }
}
