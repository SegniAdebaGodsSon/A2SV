import java.util.*;
class Solution {
    public static int shortestPathBinaryMatrix(int[][] grid)
    {
        int size = grid.length;
        if(grid[0][0] != 0|| grid[size-1][ size-1] != 0) return -1;
        if(grid.length == 1 && grid[0][0] == 0) return 1;
        Queue<int[]> queue = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        // N, NE, E, SE, S, SW, W, NW
        int[][] dirs = {{-1, 0}, {-1, 1}, {0,1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        int step = 0;
        queue.offer(new int[]{0, 0});
        visited.add(Arrays.toString(new int[]{0, 0}));
        while(queue.size() > 0)
        {
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++)
            {
                int[] currPos = queue.poll();
                if(currPos[0] == size-1 && currPos[1] == size - 1) return step+1;
                for(int[] dir : dirs)
                {
                    int[] newPos = new int[]{dir[0] + currPos[0], dir[1] + currPos[1]};
                    int newX = newPos[0], newY = newPos[1];
                    if(isInbounds(size, newPos) && grid[newX][newY] == 0 && !visited.contains(Arrays.toString(newPos)))
                    {

                        visited.add(Arrays.toString(newPos));
                        queue.offer(newPos);
                    }


                }
            }

            step++;
        }
        return -1;

    }

    public static boolean isInbounds(int size, int[] coord){
        return 0 <=coord[0] && coord[0] < size && 0 <= coord[1] && coord[1] < size;
    }
}
