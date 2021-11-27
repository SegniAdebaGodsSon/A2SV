// https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int[] squares = new int[rectangles.length];
        int maxSquare = 0;
        for(int rec=0; rec<rectangles.length; rec++){
            squares[rec] = Math.min(rectangles[rec][0], rectangles[rec][1]);
            maxSquare = Math.max(maxSquare, squares[rec]);
        }
        
        
        int count=0;
        for(int square : squares){
            if(square == maxSquare) count++;
        }
        
        return count;
    }
}