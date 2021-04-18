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

// RECURSIVELY ... DFS
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int[] res = {root.val, 1};
        bottLeft(root, 1,res);
        return res[0];
    }

    // recusively
    public void bottLeft(TreeNode node, int level, int[] result)
    {
        if(node == null) return;

        bottLeft(node.left, level+1, result);
        bottLeft(node.right, level+1, result);

        if(level > result[1]){
            result[0] = node.val;
            result[1] = level;
        }
        System.out.println(Arrays.toString(result));
    }
}

// ITERATIVELY ... BFS
class Solution2 {
    public int findBottomLeftValue(TreeNode root) {
        // Iteratively
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int leftBottom = root.val;
        while(queue.size() > 0)
        {
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(i == 0) leftBottom = curr.val;
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        return leftBottom;
    }
}