import java.util.*;
class Solution {
    public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        HashMap<Integer, List<Integer>> adjListRed = new HashMap<>();
        HashMap<Integer, List<Integer>> adjListBlue = new HashMap<>();
        Queue<int[]> queue = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        final int RED = 0, BLUE = 1;

        int[] result = new int[n];
        Arrays.fill(result, 1, n, Integer.MAX_VALUE);
        for (int[] edge : red_edges) {
            List<Integer> val = adjListRed.getOrDefault(edge[0], new ArrayList<>());
            val.add(edge[1]);
            adjListRed.put(edge[0], val);
        }
        for (int[] edge : blue_edges) {
            List<Integer> val = adjListBlue.getOrDefault(edge[0], new ArrayList<>());
            val.add(edge[1]);
            adjListBlue.put(edge[0], val);
        }

        if (!adjListRed.containsKey(0) && !adjListBlue.containsKey(0))
        {
            for(int i=0; i<n; i++){
                if(result[i] == Integer.MAX_VALUE) {
                    result[i] = -1;
                    System.out.println(i);
                }
            }
            return result;
        }

        if (adjListRed.containsKey(0))
        {
            for (int neighbor : adjListRed.get(0))
            {
                String path = new StringBuilder().append("R").append(0).append("-").append(neighbor).toString();
                visited.add(path);
                queue.offer(new int[]{neighbor, RED});
            }
        }
        if (adjListBlue.containsKey(0))
        {
            for (int neighbor : adjListBlue.get(0))
            {
                String path = new StringBuilder().append("B").append(0).append("-").append(neighbor).toString();
                visited.add(path);
                queue.offer(new int[]{neighbor, BLUE});
            }
        }

        int step = 1;


        while (queue.size() > 0) {
            int size = queue.size();
            System.out.println(visited);

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                result[curr[0]] = Math.min(step, result[curr[0]]);
//                System.out.println(Arrays.toString(result));


                if (curr[1] == RED && adjListBlue.containsKey(curr[0]))
                    for (int neighbor : adjListBlue.get(curr[0]))
                    {
                        String path = new StringBuilder().append("R").append(curr[0]).append("-").append(neighbor).toString();
                        if(!visited.contains(path))
                        {
                            queue.offer(new int[]{neighbor, BLUE});
                            visited.add(path);
                        }
                    }
                else if (curr[1] == BLUE && adjListRed.containsKey(curr[0]))
                    for (int neighbor : adjListRed.get(curr[0]))
                    {
                        String path = new StringBuilder().append("B").append(curr[0]).append("-").append(neighbor).toString();
                        if(!visited.contains(path))
                        {
                            queue.offer(new int[]{neighbor, RED});
                            visited.add(path);
                        }
                    }

            }
            step++;
        }

        System.out.println(Arrays.toString(result));
        for(int i=0; i<n; i++){
            if(result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
                System.out.println(i);
            }
        }
        return result;
    }

}