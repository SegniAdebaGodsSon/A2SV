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

// ITERATIVELY
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        // better use LinkedList<>() here b/c it allows null values to be stored
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while(queue.size() > 0)
        {
            TreeNode curr1 = queue.poll();
            TreeNode curr2 = queue.poll();

            if(curr1 == null && curr2 == null) continue;
            if(curr1 == null || curr2 == null) return false;
            if(curr1.val != curr2.val) return false;
            queue.offer(curr1.left);
            queue.offer(curr2.right);
            queue.offer(curr1.right);
            queue.offer(curr2.left);

        }

        return true;

    }
}

class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        TreeNode leftSubtree = root.left;
        TreeNode rightSubtree = root.right;
        return SymmHelper(leftSubtree, rightSubtree);
    }

    public boolean SymmHelper(TreeNode node1, TreeNode node2)
    {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;

        boolean l = SymmHelper(node1.left, node2.right);
        boolean r = SymmHelper(node1.right, node2.left);

        return l&&r;
    }
}