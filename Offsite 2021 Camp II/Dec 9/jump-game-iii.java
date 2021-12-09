// https://leetcode.com/problems/jump-game-iii/
class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0) return true;
        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        
        q.offer(start);
        visited.add(start);
        
        while(!q.isEmpty()){
            int currInd = q.poll();
            int left = currInd - arr[currInd];
            int right = currInd + arr[currInd];
            
            if(!visited.contains(left) && validIndex(arr, left)){
                if(arr[left] == 0) return true;
                q.offer(left);
                visited.add(left);
            }
            
            if(!visited.contains(right) && validIndex(arr, right)){
                if(arr[right] == 0) return true;
                q.offer(right);
                visited.add(right);
            }
            
        }
        return false;

    }
    
    public boolean validIndex(int[] arr, int ind){
        return 0<= ind && ind < arr.length;
    }
}