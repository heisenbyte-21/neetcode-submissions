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
    boolean isValid = false;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return !isValid;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        isValid = isValid || (Math.abs(left - right) > 1);

        return 1 + Math.max(left, right);
    }
}
