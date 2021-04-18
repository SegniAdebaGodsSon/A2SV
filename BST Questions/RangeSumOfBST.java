import java.util.*;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        return rangeSumHelper(root, low, high);
    }

    public int rangeSumHelper(TreeNode node, int low, int high){
        if(node == null) return 0;

        int sum = 0;
        if(low <= node.val && node.val <= high) sum+=node.val;
        sum += rangeSumHelper(node.left, low, high) + rangeSumHelper(node.right, low, high);
        return sum;
    }


}