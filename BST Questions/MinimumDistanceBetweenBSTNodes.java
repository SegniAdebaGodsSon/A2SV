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
    public int minDiffInBST(TreeNode root) {
        int[] result = {Integer.MAX_VALUE, -1};
        minDiffHelper(root, result);
        return result[0];

    }

    public void minDiffHelper(TreeNode node, int[] res){
        if(node == null) return;

        minDiffHelper(node.left, res);

        if(res[1] != -1) res[0] = Math.min(Math.abs(node.val - res[1]), res[0]);
        res[1] = node.val;

        minDiffHelper(node.right, res);

    }
}