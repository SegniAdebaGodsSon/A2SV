import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid)
    {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int fresh = 0, time = -1;           // starting from -1 because we don't count at first, where we have oranges already rotten
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// up, right, down, left
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for(int row=0; row<grid.length; row++)
        {
            for(int column=0; column<grid[0].length; column++)
            {
                if(grid[row][column] == 1)			 // fresh orange
                    fresh++;
                else if(grid[row][column] == 2) 		// rotten orange
                    queue.offer(new int[]{row, column});
            }
        }

        if(fresh == 0) return 0;

        while(queue.size() > 0)
        {

            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                int[] curr = queue.poll();
                for(int[] dir : dirs)
                {
                    int[] currCoor = new int[]{curr[0] + dir[0], curr[1] + dir[1]};
                    if(inBounds(grid, currCoor) && grid[currCoor[0]][currCoor[1]] == 1)
                    {
                        grid[currCoor[0]][currCoor[1]] = 2;
                        queue.offer(currCoor);
                        fresh--;
                    }
                }



            } // for(level)
            time++;
            System.out.println("");

        } // while loop


        return fresh == 0 ? time: -1 ;
    } // rottingOranges()

    private static boolean inBounds(int[][] matrix, int[] coordinate)
    {
        return 0 <= coordinate[0] && coordinate[0] < matrix.length  && 0 <= coordinate[1] && coordinate[1] < matrix[0].length;
    }

}