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
    private Map<Integer, Integer> leftMostIndexMap = new HashMap<>();
    private int ans = 0;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 0);
        return ans;
    }

    private void dfs(TreeNode root, int index, int depth) {
        if (root == null)
            return;
        if (leftMostIndexMap.get(depth) == null)
            leftMostIndexMap.put(depth, index);
        ans = Math.max(ans, index - leftMostIndexMap.get(depth) + 1);
        dfs(root.left, index * 2, depth + 1);
        dfs(root.right, index * 2 + 1, depth + 1);
    }
}