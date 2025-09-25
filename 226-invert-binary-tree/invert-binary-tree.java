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
        //dfs traversal 
        //base condition
        if(root==null){
            return null;
        }
        //traverse to the left and right tree
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        //create a temp node for swaping
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;

    }
}

//tc - O(n)
//sc - O(h)