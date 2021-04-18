import java.util.ArrayList;

// Definition for a binary tree node.
 class TreeNode {
    int val;
     TreeNode left;
    TreeNode right;
    TreeNode() {}
     TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
}
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        kthSmHelper(root, arr);
        return arr.get(k-1);
    }

    public void kthSmHelper(TreeNode node, ArrayList<Integer> arr)
    {
        if(node == null) return;
        kthSmHelper(node.left, arr);
        arr.add(node.val);
        kthSmHelper(node.right, arr);
    }
}