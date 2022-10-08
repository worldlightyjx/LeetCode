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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode cur, List<Integer> res, int depth) {
        if (cur == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(cur.val);
        }

        dfs(cur.right, res, depth + 1);
        dfs(cur.left, res, depth + 1);

    }
}