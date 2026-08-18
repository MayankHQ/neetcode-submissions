# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        balanced = True

        def height(node):
            nonlocal balanced
            if not node:
                return 0
            
            leftHt = height(node.left)
            if balanced == False: return 0 #no need to enter right side
            rightHt = height(node.right)

            if abs(leftHt - rightHt) > 1:
                balanced = False
                return 0
            
            return 1 + max(leftHt, rightHt)
        
        height(root)

        return balanced