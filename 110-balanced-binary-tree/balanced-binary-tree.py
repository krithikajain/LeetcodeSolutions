# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def checkHeight(node):
            if not node:
                return 0 #empty tree has height 0
            
            left_height = checkHeight(node.left)
            if left_height == -1:
                return -1; #left subtree is unbalanced
            right_height = checkHeight(node.right)
            if right_height == -1:
                return -1; #right subtree is unbalanced

            if abs(left_height-right_height)>1: #node is unbalanced
                return -1
            
            return max(left_height, right_height)+1 #node is balanced return it's height
        
        return checkHeight(root)!= -1 #if -1 is returned then the tree is unbalanced