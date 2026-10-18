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
    public void traverseLeft(TreeNode root,Stack<TreeNode>st){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode>st = new Stack<>();
        traverseLeft(root,st);
        while(!st.isEmpty()){
            TreeNode n = st.pop();
            if(k==1)
                return n.val;
            if(n.right!=null){
                n = n.right;
                traverseLeft(n,st);
            }
            k--;
        }
        return 0;
    }
}
