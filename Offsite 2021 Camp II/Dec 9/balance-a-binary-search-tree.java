// https://leetcode.com/problems/balance-a-binary-search-tree/
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
    List<TreeNode> nodes = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        dfs(root);
        TreeNode balanced = balance(0, nodes.size()-1);
        
        return balanced;
    }
    
    public TreeNode balance(int start, int end){
        if(start >= nodes.size() || end < 0 || end < start) return null;
        if(start == end){
            nodes.get(start).left = null;
            nodes.get(start).right = null;
            return nodes.get(start);
        }
        
        int mid = start + (end - start) / 2;
        TreeNode curr = nodes.get(mid);
        curr.left = balance(start, mid - 1);
        curr.right = balance(mid + 1, end);
        
        return curr;
    } 
    
    
    public void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);
        nodes.add(node);
        dfs(node.right);
    }
}