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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode>stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while(k>0){
            k--;
            TreeNode n = stack.pop();
            if(k==0){
                return n.val;
            }
            if(n.right!=null){
                n = n.right;
                stack.push(n);
                while(n.left!=null){
                    n = n.left;
                    stack.push(n);
                }
            }
        }
        return -1;
        
    }
}
