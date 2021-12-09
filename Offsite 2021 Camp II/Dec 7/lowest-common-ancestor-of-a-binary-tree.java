// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
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
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }
    
    public boolean[] dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return new boolean[]{false, false};
        boolean[] l = dfs(node.left, p, q);
        boolean[] r = dfs(node.right, p, q);
        
        boolean[] ans = {l[0] || r[0], l[1] || r[1]};
        
        if(node == p) ans[0] = true;
        if(node == q) ans[1] = true;
        
        if(ans[0] == ans[1] && ans[0] == true && lca == null){
            lca = node;    
        }
        
        return ans;
    }
}