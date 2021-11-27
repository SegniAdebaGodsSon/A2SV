// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

class Solution {
    final static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, right, down, left
    
    public boolean isInBounds(int[][] matrix, int[] coord){
        int rows = matrix.length, cols = matrix[0].length;
        return 0 <= coord[0] && coord[0] < rows && 0 <= coord[1] && coord[1] < cols;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, 
            cols = matrix[0].length;
        
        // initialize memo distance from each node/coordinate
        int[][] distanceFromCoord = new int[rows][cols];
        for (int[] row : distanceFromCoord) Arrays.fill(row, -1);
        
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(distanceFromCoord[row][col] == -1){
                    int[] coord = {row, col};
                    distanceFromCoord[row][col] = DFS(matrix, coord, distanceFromCoord);
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(distanceFromCoord));
        
        int max = Integer.MIN_VALUE;
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                max = Math.max(max, distanceFromCoord[row][col]);
            }
        }
        return max;
    }
    
    public int DFS(int[][] matrix, int[] coord, int[][] distanceFromCoord){
        int row = coord[0], col = coord[1];
        if(distanceFromCoord[row][col] > -1) return distanceFromCoord[row][col];
        
        int distance = 1;
        
        int max = 0;
        for(int[] dir : dirs){
            int[] newCoord = {dir[0] + row, dir[1] + col};
            int newX = newCoord[0], newY = newCoord[1];
            
            if(isInBounds(matrix, newCoord) && 
              matrix[row][col] < matrix[newX][newY]){
                
                max = Math.max(max, DFS(matrix, newCoord, distanceFromCoord));
            }
        }
        
        distance += max;
        distanceFromCoord[row][col] = distance;
        return distance;
    }
    
}