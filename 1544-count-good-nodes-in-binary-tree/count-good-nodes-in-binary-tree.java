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
    int count=0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }
    private void dfs(TreeNode cur, int max){
        if(cur==null){
            return;
        }
        if(cur.val>=max){
            max=cur.val;
            count++;
        }
        dfs(cur.left,max);
        dfs(cur.right,max);
    }
}