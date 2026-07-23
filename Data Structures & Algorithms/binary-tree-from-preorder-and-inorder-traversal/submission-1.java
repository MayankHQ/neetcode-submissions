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
    public int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            hash.put(inorder[i], i);
        }

        return construct(preorder, inorder, 0, inorder.length - 1, hash);
    }
    public TreeNode construct(int[] preorder, int[] inorder, int left, int right, Map<Integer,Integer> hash){
        if(left > right) return null;

        int current = preorder[index++];
        TreeNode node = new TreeNode(current);
        int inorderIdx = hash.get(current);

        node.left = construct(preorder, inorder, left, inorderIdx - 1, hash);
        node.right = construct(preorder, inorder, inorderIdx + 1, right, hash);

        return node;
    }
}
