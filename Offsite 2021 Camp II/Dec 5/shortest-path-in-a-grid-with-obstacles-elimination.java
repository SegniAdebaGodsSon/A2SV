// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

class Node{
	int[] coord;
	int k;
	int steps;
	Node(int[] coord, int k, int steps){
        this.coord = coord;
        this.k  = k; 
        this.steps = steps;
      }
    
    @Override
    public String toString(){
        return "Node( coord: " + Arrays.toString(coord) + "  k: " + k + " steps: " + steps;
    }
}

class Solution {
    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right down left up
    final int EMPTY = 0;
    final int OBSTACLE = 1;
    public int shortestPath(int[][] grid, int k) {
        int rows=grid.length, cols=grid[0].length;
        boolean[][][] visited = new boolean[rows][cols][k+1];
     
        Queue<Node> q = new ArrayDeque<>();
        int initK = grid[0][0] == OBSTACLE ? 1: 0;
        q.offer(new Node(new int[]{0, 0}, initK, 0));
        visited[0][0][0] = true;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.coord[0] == rows-1 && curr.coord[1] == cols-1) return curr.steps;
            
            for(int[] dir : dirs){
                int[] newCoord = {curr.coord[0] + dir[0], curr.coord[1] + dir[1]};
                if(isInBounds(rows, cols, newCoord)){
                    int newK = curr.k + grid[newCoord[0]][newCoord[1]];
                    if(newK <= k && !visited[newCoord[0]][newCoord[1]][newK]){
                        visited[newCoord[0]][newCoord[1]][newK] = true;
                        q.offer(new Node(newCoord, newK, curr.steps+1));
                    }
                 
                }
            }
            
        }
        return -1;

    }
    
    public boolean isInBounds(int rows, int cols, int[] coord){
        return 0 <= coord[0] && coord[0] < rows && 0 <= coord[1] && coord[1] < cols;
    }
}