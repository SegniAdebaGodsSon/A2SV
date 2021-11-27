// https://leetcode.com/problems/flipping-an-image/

// solution #1
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int row=0; row<image.length; row++){
            flip(image[row]);
        }
        
        invert(image);
        return image;
        
    }
    
    public void flip(int[] arr){
        for(int i=0; i<arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
    
    public void invert(int[][] matrix){
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                int curr = matrix[row][col];
                matrix[row][col] = curr == 1 ? 0 : 1;
            }
        }
    }
}




// solution #2
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }
    
     
}