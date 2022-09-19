/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    TreeNode x = null;
    TreeNode y = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        dfs(root);

        if (x != null && y != null) {
            TreeNode tmp = new TreeNode();
            tmp.val = x.val;
            x.val = y.val;
            y.val = tmp.val;
        }

    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (pre == null) {
            pre = root;
        } else {
            if (pre.val > root.val) {
                y = root;
                if (x == null) {
                    x = pre;
                }
            }

            pre = root;
        }

        dfs(root.right);
    }
}