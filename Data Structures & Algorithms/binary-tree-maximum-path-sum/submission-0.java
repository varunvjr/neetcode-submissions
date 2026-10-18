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
    public int maxPathSum(TreeNode root) {
        int res[] = new int[1];
        res[0] = root.val;
        dfs(root,res);
        return res[0];
    }
    public int dfs(TreeNode root,int res[]){
        if(root==null)
            return 0;
        int lmax = dfs(root.left,res);
        int rmax = dfs(root.right,res);
        lmax = Math.max(lmax,0);
        rmax = Math.max(rmax,0);
        res[0] = Math.max(res[0],lmax+rmax+root.val);
        return root.val+Math.max(lmax,rmax);
    }
}
