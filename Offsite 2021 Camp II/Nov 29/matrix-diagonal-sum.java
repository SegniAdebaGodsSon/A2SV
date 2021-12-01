// https://leetcode.com/problems/matrix-diagonal-sum/
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0, rows = mat.length, cols = mat[0].length;
        
        int d1=0, d2=rows-1;
        for(int row=0; row<rows; row++){
            sum += mat[row][d1++] + mat[row][d2--];
        }
        
        return rows % 2 == 0 ? sum : sum - mat[rows/2][cols/2];
        
    }
}