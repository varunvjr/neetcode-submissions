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
    public static int idx;
    public TreeNode constructTree(HashMap<Integer,Integer>map, int preorder[],int left,int right){
        if(left>right)
            return null;
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = constructTree(map,preorder,left,map.get(root.val)-1);
        root.right = constructTree(map,preorder,map.get(root.val)+1,right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        idx = 0;
        TreeNode res = constructTree(map,preorder,0,preorder.length-1);
        return res;
    }
}
