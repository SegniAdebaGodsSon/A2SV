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


// ITERATIVELY USING STACK
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        // Iteratively, basically BFS
        if(root == null) return new ArrayList<>();
        List<Integer> result = new LinkedList<>();

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);
        while(stack.size() > 0 )
        {
            TreeNode curr = stack.pop();
            System.out.println(curr.val);
            result.add(0, curr.val);
            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);

        }


        return result;

    }

}

// RECURSIVELY ... DFS
class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        postOrdHelper(root, result);
        return result;

    }

    public void postOrdHelper(TreeNode node, List<Integer> result)
    {
        if(node == null) return;
        postOrdHelper(node.left, result);
        postOrdHelper(node.right, result);
        result.add(node.val);

    }
}