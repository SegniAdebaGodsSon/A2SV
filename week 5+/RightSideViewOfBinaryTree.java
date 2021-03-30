import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public static void main(String[] args) {

    }

    // ================== BFS SOLUTION ==================
    public static ArrayList<Integer> rightSideViewBFS(TreeNode root){
        if(root == null) return new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        queue.offer(root);
        int size = queue.size();
        int count = 0;
        while(queue.size() > 0 ){
            TreeNode current = queue.poll();
            count++;
            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
            if(count == size){
                result.add(current.val);
                size = queue.size();
                count = 0;
            }
        }
        return result;
    }

    // ================== DFS SOLUTION ==================
    public static List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        HashMap<Integer, Integer> levels = new HashMap<>();
        rightViewHelper(levels, 0, root);
        return new ArrayList<>(levels.values());
    }

    public static void rightViewHelper(HashMap<Integer, Integer> levels, int level, TreeNode node){
        if(node == null) return;
        if(!levels.containsKey(level))
            levels.put(level, node.val);
        rightViewHelper(levels, level + 1, node.right);
        rightViewHelper(levels, level + 1, node.left);
    }
}