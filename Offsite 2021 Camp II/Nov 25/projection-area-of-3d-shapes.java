// https://leetcode.com/problems/projection-area-of-3d-shapes/

// solution #1 - three d/t iterations

	class Solution {
    public int projectionArea(int[][] grid) {
        return xyPlaneArea(grid) + xzPlaneArea(grid) + yzPlaneArea(grid);
    }
    
    public int xyPlaneArea(int[][] grid){
        int area = 0, rows=grid.length, cols=grid[0].length;
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(grid[row][col] > 0) area++;
            }
        }
        return area;
    }
    
    public int xzPlaneArea(int[][] grid){
        int area = 0, rows=grid.length, cols=grid[0].length;
        for(int row=0; row<rows; row++){
            int localMax = -1;
            for(int col=0; col<cols; col++){
                localMax = Math.max(localMax, grid[row][col]);
            }
            area+=localMax;
        }
        return area;
    }
    
    public int yzPlaneArea(int[][] grid){
        int area = 0, rows=grid.length, cols=grid[0].length;
        for(int col=0; col<cols; col++){
            int localMax = -1;
            for(int row=0; row<rows; row++){
                localMax = Math.max(localMax, grid[row][col]);
            }
            area+=localMax;
        }
        return area;
    }
    
}






// solution #2 - using just one iteration
class Solution {
    public int projectionArea(int[][] grid) {
        return totalPlaneArea(grid);
    }
    
    
    // all in one loop
    public int totalPlaneArea(int[][] grid){
        int area = 0;
        int rows=grid.length, cols=grid[0].length;
        for(int row=0; row<rows; row++){
            int yz = 0, xz = 0;
            for(int col=0; col<cols; col++){
                if(grid[row][col] > 0) area++;
                yz = Math.max(yz, grid[row][col]);
                xz = Math.max(xz, grid[col][row]);
            }
            area += xz + yz;
        }
        return area;
    }
    
}