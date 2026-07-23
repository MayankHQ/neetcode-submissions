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
    List<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        right(root, 0);
        return list;
    }
    public void right(TreeNode root, int level){ //reverse preorder
        if(root == null) return;
        if(level == list.size()) list.add(root.val);
        right(root.right, level + 1);
        right(root.left, level + 1);
    }
}
