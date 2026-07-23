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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode construct(int[] preorder, int[] inorder, int pLow, int pHi, int iLow, int iHi){
        if(pLow > pHi || iLow > iHi) return null;

        TreeNode nn = new TreeNode(preorder[pLow]);
        int index = search(inorder, iLow, iHi, preorder[pLow]);
        int nel = index - iLow;

        nn.left = construct(preorder, inorder, pLow + 1, pLow + nel, iLow, index -1);
        nn.right = construct(preorder, inorder, pLow + nel + 1, pHi, index + 1, iHi);

        return nn;
    }

    public int search(int[] inorder, int startI, int endI, int target){
        for(int i = startI; i <= endI; i++){
            if(inorder[i] == target) return i;
        }
        return 0;
    }
}
