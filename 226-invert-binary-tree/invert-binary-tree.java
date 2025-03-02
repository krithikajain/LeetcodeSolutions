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
    public TreeNode invertTree(TreeNode root) {
        //base condition for recursion
        if(root==null){
            return null;
        }
        //traverse to the left tree and right tree
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        //create a temp node to hold the value of left subtree temperorily
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
         return root;
    }
}