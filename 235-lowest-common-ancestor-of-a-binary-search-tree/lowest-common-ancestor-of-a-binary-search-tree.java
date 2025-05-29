/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            //check nodes p and q are smaller than the current node -> go left
            if(p.val<root.val && q.val<root.val){
                root=root.left;
            }
            //check if p and q are larger than current node -> right
            else if(p.val>root.val && q.val>root.val){
                root=root.right;
            }
            //if the node.val is inbetween left and right or equal to itself then we split(call itself)
            else{
                return root;
            }
        }
        return null;
    }
}