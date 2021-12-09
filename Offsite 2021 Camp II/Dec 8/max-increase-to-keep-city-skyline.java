// https://leetcode.com/problems/max-increase-to-keep-city-skyline/
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] rowMaxes = new int[rows];
        int[] colMaxes = new int[cols];
        
        for(int i=0; i<rows; i++){
            int rowMax = Integer.MIN_VALUE, colMax = Integer.MIN_VALUE;
            for(int j=0; j<cols; j++){
                rowMax = Math.max(rowMax, grid[i][j]);
                colMax = Math.max(colMax, grid[j][i]);
            }
            rowMaxes[i] = rowMax;
            colMaxes[i] = colMax;
        }
        
        int ans = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int max = Math.min(rowMaxes[i], colMaxes[j]);
                if(grid[i][j] < max) ans += max-grid[i][j];
            }
        }
        
        return ans;
    }
}