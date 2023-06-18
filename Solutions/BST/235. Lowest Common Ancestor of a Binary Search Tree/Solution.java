import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> path1 = getPath(root,p);
        List<TreeNode> path2 = getPath(root,q);
        TreeNode ancestor = null;
        for(int i =0 ; i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)==path2.get(i)){
                ancestor = path1.get(i);
            }else{
                break;
            }
        }
        return ancestor;
        
        
        
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode targTreeNode) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode curNode  = root;
        while(curNode!=targTreeNode){
            path.add(curNode);
            if(curNode.val>targTreeNode.val){
                curNode = curNode.left;
            }else{
                curNode = curNode.right;
            }
        }
        path.add(curNode);
        return path;
    }
}