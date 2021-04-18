import java.util.*;
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int[] edge : edges)
        {
            ArrayList<Integer> val = adjList.getOrDefault(edge[0], new ArrayList<>());
            ArrayList<Integer> val2 =  adjList.getOrDefault(edge[1], new ArrayList<>());
            val.add(edge[1]);
            val2.add(edge[0]);
            adjList.put(edge[0], val);
            adjList.put(edge[1], val2);

        }
        System.out.println(adjList);

        int rec = minTimeHelper(edges[0][0], adjList, hasApple, visited);

        return rec == 0 ? 0 : (rec - 1 )* 2;

    }

    public int minTimeHelper(int node, HashMap<Integer, ArrayList<Integer>> adjList, List<Boolean> hasApple, HashSet<Integer> visited)
    {

        int count = 0;
        visited.add(node);
        for(Integer child : adjList.getOrDefault(node, new ArrayList<>()))
        {
            if(!visited.contains(child))
                count += minTimeHelper(child, adjList, hasApple, visited);
        }

        System.out.println(node + " - " + count);
        if(hasApple.get(node) || count > 0) count++;
        return count;
    }

}