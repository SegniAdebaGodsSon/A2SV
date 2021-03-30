import java.util.ArrayDeque;

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
    public int sumEvenGrandparent(TreeNode root) {
        TreeNode temp = new TreeNode(1);
        temp.left = root;
        int[] sum = new int[1];
        sumEvenHelperDFS(root, sum, new TreeNode[]{temp, null});
        return sum[0];
        // return sumEvenHelperBFS(root);
    }

    public int sumEvenHelperBFS(TreeNode node) {
        ArrayDeque<TreeNode[]> level = new ArrayDeque<>();
        TreeNode[] root = {node, null};
        level.add(root);
        int count = 0;

        while (!level.isEmpty()) {
            int size = level.size();

            for (int i = 0; i < size; i++) {
                TreeNode[] popped = level.poll();

                if (popped[0].left != null) {
                    if (popped[1] != null && popped[1].val % 2 == 0) count += popped[0].left.val;
                    TreeNode[] left = {popped[0].left, popped[0]};
                    level.add(left);
                }

                if (popped[0].right != null) {
                    if (popped[1] != null && popped[1].val % 2 == 0) count += popped[0].right.val;

                    TreeNode[] right = {popped[0].right, popped[0]};
                    level.add(right);
                }
                ;
            }
        }
        return count;
    }

    public void sumEvenHelperDFS(TreeNode node, int[] count, TreeNode[] parents) {
        if (node == null) return;
        if (parents[1] != null && parents[1].val % 2 == 0) count[0] += node.val;
        sumEvenHelperDFS(node.left, count, new TreeNode[]{node, parents[0]});
        sumEvenHelperDFS(node.right, count, new TreeNode[]{node, parents[0]});
    }


}