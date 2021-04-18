import java.util.*;
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
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);     // doesn't work with Long.MIN_VALUE, and MAX_VALUE, b/c the input can include them, and we cannot increase or decrease them b/c they'd no more be ints
    }

    public Boolean valid(TreeNode node, Long min, Long max){
        if(node==null) return true;
        if(node.val <= min || node.val >= max) return false;
        return valid(node.left, min, (long) node.val)&&valid(node.right, (long) node.val, max);
    }
}
