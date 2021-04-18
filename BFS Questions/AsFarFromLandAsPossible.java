import java.util.*;
class Solution {
    public static int maxDistance(int[][] grid)
    {
        if(grid.length == 0 || grid[0].length == 0) return -1;
        final int LAND = 1, WATER = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        ArrayList<int[]> lands = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int row=0; row<grid.length; row++)
        {
            for(int column=0; column<grid[0].length; column++)
                if(grid[row][column] == LAND)
                {
                    queue.offer(new int[]{row, column});
                    visited.add(Arrays.toString(new int[]{row, column}));
                    lands.add(new int[]{row, column});
                }
        }

        if(lands.size() == 0) return -1;

        int[] lastVisited = {};
        while( queue.size() > 0)
        {
            int levelSize = queue.size();

            for(int i=0; i<levelSize; i++)
            {
                int[] curr = queue.poll();
                for(int[] dir : dirs)
                {
                    int[] newCoord = new int[]{curr[0] + dir[0], curr[1] + dir[1]};
                    int newX = newCoord[0], newY = newCoord[1];
                    if(isInbounds(grid, newCoord) && grid[newX][newY] == WATER && !visited.contains(Arrays.toString(newCoord)))
                    {
                        lastVisited = newCoord;
                        visited.add(Arrays.toString(newCoord));
                        queue.offer(newCoord);
                    }

                } // dirs
            } // level

        } // while


        int distance = Integer.MAX_VALUE;
//        System.out.println("Last Visited: " + Arrays.toString(lastVisited));
        if(lastVisited.length == 0) return -1;
        for(int[] land : lands)
        {
            int xDiff = Math.abs(land[0] - lastVisited[0]);
            int yDiff = Math.abs(land[1] - lastVisited[1]);
//            System.out.println(Arrays.toString(land) + " - " + Arrays.toString(lastVisited));
//            System.out.println(xDiff+ ", " + yDiff);
            distance = Math.min(distance, xDiff + yDiff);
        }

        return distance;

    }

    public static boolean isInbounds(int[][] grid, int[] coord)
    {
        return 0 <= coord[0] && coord[0] < grid.length  && 0 <= coord[1] && coord[1] < grid[0].length;
    }
}