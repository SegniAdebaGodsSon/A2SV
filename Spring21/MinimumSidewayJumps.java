import java.util.*;

class Solution {
    public int minSideJumps(int[] obstacles) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{2, 0, 0});       // 2D array of index 0 : Lane and index 1 : Step and index 2 : jumps
        boolean[][] visited = new boolean[4][obstacles.length];

        int jumps = 0, currLane , currStep = 0;

        while(queue.size() > 0)
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                int[] curr = queue.poll();
                currLane = curr[0];
                currStep = curr[1];
                jumps = curr[2];

                // at the end of the road
                if(currStep == obstacles.length - 1) return jumps;

                // visited or hit an obstacle
                if(obstacles[currStep] == currLane || visited[currLane][currStep]) continue;

                visited[currLane][currStep] = true;


                for(int j=1; j<=3; j++) // all the side hops
                {
                    if(currLane == j)   // if it's self, go forward
                        queue.offer(new int[]{currLane, currStep+1, jumps});
                    else                // if not it's self, go to those lanes
                        queue.offer(new int[]{j, currStep, jumps+1});

                }
            }
        }
        return jumps;
    }
}