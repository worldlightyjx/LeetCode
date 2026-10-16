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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return dfs(root, targetSum, sum);

    }

    private boolean dfs(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                return true;
            } else {
                return false;
            }
        }
        boolean l = false, r = false;
        if (root.left != null) {
            l = dfs(root.left, targetSum, sum);
        }
        if (root.right != null) {
            r = dfs(root.right, targetSum, sum);
        }
        sum -= root.val;
        return l || r;
    }
}