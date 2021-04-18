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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    public TreeNode helper(int[] nums, int left, int right)
    {
        if(left == right) return null;
        int max_ind = maxInd(nums, left, right);
        TreeNode node = new TreeNode(
                nums[max_ind],
                helper(nums, left, max_ind),
                helper(nums, max_ind + 1, right)
        );

        return node;

    }

    public int maxInd(int[] arr, int l, int r)
    {
        int ind = l;
        for(int i=l; i<r; i++)
        {
            if(arr[ind] < arr[i]) ind = i;
        }
        return ind;
    }
}
