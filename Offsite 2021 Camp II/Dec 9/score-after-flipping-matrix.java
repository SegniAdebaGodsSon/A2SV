// https://leetcode.com/problems/score-after-flipping-matrix/
class Solution {
    public int matrixScore(int[][] grid) {
        int sum = 0, rows = grid.length, cols = grid[0].length;
        
        // check rows
        for(int row=0; row<rows; row++){
            if(grid[row][0] == 0){
                for(int col=0; col<cols; col++){
                    grid[row][col] = toggle(grid[row][col]);
                }
            }
        }
        
        int[] colZeroCounts = new int[cols];
        for(int col=0; col<cols; col++){
            for(int row=0; row<rows; row++){
                if(grid[row][col] == 0) colZeroCounts[col]++;
            }
        }
        // System.out.println(Arrays.toString(colZeroCounts));
        // System.out.println(Arrays.deepToString(grid));

        
        
        for(int col=0; col<cols; col++){
            if(colZeroCounts[col] > rows/2){
                for(int row=0; row<rows; row++){
                    grid[row][col] = toggle(grid[row][col]);
                }
            }
            
        }
        
        // System.out.println(Arrays.deepToString(grid));
        
        for(int row=0; row<rows; row++){
            int rowSum = 0;
            for(int col=0; col<cols; col++){
                rowSum = rowSum << 1 | grid[row][col];
            }
            sum += rowSum;
        }
        
        
        return sum;
    }
    
    public int toggle(int i){
        return i == 0 ? 1 : 0;
    }
}