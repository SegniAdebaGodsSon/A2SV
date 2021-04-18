import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // north, east, south, west

        for(int row=0; row<isWater.length; row++)
        {
            for(int column=0; column<isWater[0].length; column++)
            {
                if(isWater[row][column] == 1)
                {
                    isWater[row][column] = 0;
                    queue.offer(new int[]{row, column});
                }
                else isWater[row][column] = Integer.MAX_VALUE;
            }
        }


        int level = 1;
        while(queue.size() > 0)
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                int[] curr = queue.poll();

                // System.out.println(Arrays.toString(curr));

                for(int[] dir : dirs)
                {
                    int[] neighbor = {dir[0] + curr[0], dir[1] + curr[1]};
                    int newX = neighbor[0], newY = neighbor[1];
                    if(isInbounds(isWater, neighbor) && isWater[newX][newY] == Integer.MAX_VALUE){
                        queue.offer(neighbor);
                        isWater[newX][newY] = level;

                    }
                }
            }

            level++;
        }

        return isWater;
    }

    public boolean isInbounds(int[][] grid, int[] coord)
    {
        return 0<=coord[0] && coord[0] < grid.length && 0<=coord[1] && coord[1] < grid[0].length;
    }
}