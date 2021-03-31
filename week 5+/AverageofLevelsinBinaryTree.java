
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();
        queue.add(root);
        int size = queue.size(), levelElements = 0;
        double levelSum = 0;
        while(queue.size() > 0){
            TreeNode popped = queue.poll();
            levelElements ++;
            if(popped.left != null) queue.offer(popped.left);
            if(popped.right != null) queue.offer(popped.right);
            levelSum += popped.val;

            if(size == levelElements){
                result.add(levelSum /size);
                size = queue.size();
                levelElements = 0;
                levelSum = 0;
            }
        }
        return result;
    }


    // EASIER TO KEEP TRACK OF LEVELS WITH FOR LOOP
    public List<Double> averageOfLevels2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();
        queue.add(root);

        while(queue.size() > 0){
            int size = queue.size();
            double levelSum = 0;

            for(int i=0; i<size; i++){
                TreeNode popped = queue.poll();
                if(popped.left != null) queue.offer(popped.left);
                if(popped.right != null) queue.offer(popped.right);
                levelSum += popped.val;
            }

            result.add(levelSum/size);
        }
        return result;
    }
}