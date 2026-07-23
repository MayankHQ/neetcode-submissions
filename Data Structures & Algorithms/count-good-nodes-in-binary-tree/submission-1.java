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
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }
    public int helper(TreeNode node, int maxSoFar){
        if(node == null) return 0;

        int cnt = 0;
        if(node.val >= maxSoFar) cnt++;

        int newMax = Math.max(maxSoFar, node.val);

        cnt += helper(node.left, newMax);
        cnt += helper(node.right, newMax);

        return cnt;
    }
}
