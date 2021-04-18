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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return root1;
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();

        root1.val = root1.val + root2.val;
        root2.val = root1.val + root2.val;

        q1.offer(root1);
        q2.offer(root2);

        while (q1.size() > 0 || q2.size() > 0) {
            TreeNode curr1 = q1.poll();
            TreeNode curr2 = q2.poll();
            System.out.println(curr1.val + " - " + curr2.val);


            if (curr1.left == null || curr2.left == null) {
                if (curr1.left == null && curr2.left != null) curr1.left = curr2.left;
                else if (curr1.left != null && curr2.left == null) curr2.left = curr1.left;

            } else {
                curr1.left.val = curr1.left.val + curr2.left.val;
                curr2.left.val = curr1.left.val + curr2.left.val;
                q1.offer(curr1.left);
                q2.offer(curr2.left);

            }


            if (curr1.right == null || curr2.right == null) {
                if (curr1.right == null && curr2.right != null) curr1.right = curr2.right;
                else if (curr1.right != null && curr2.right == null) curr2.right = curr1.right;

            } else {
                curr1.right.val = curr1.right.val + curr2.right.val;
                curr2.right.val = curr1.right.val + curr2.right.val;
                q1.offer(curr1.right);
                q2.offer(curr2.right);

            }


        }

        return root1;

    }
}