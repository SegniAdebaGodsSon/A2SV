// https://leetcode.com/problems/parallel-courses-iii/submissions/
class Solution {
     public static HashMap<Integer, List<Integer>> generateAdjList(int n, int[][] relations){
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=1; i<=n; i++) adjList.put(i, new ArrayList<>());
        for(int[] relation : relations) adjList.get(relation[0]).add(relation[1]);
        return adjList;
    }

    public static int minimumTime(int n, int[][] relations, int[] time) {
        int[] indegrees = new int[n+1];   // not using 0th index
        HashMap<Integer, List<Integer>> adjList = generateAdjList(n, relations);
        for(int[] relation : relations) indegrees[relation[1]]++;

        int[] distances = new int[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            if(indegrees[i] == 0){
                distances[i] = time[i-1];
                q.offer(i);
            }
        }


        int totalTime = 0;

        while (!q.isEmpty()){
            int levelSize = q.size();
            while (levelSize-- > 0){
                int curr = q.poll();
                for (int neighbour : adjList.get(curr)) {
                    distances[neighbour] = Math.max(distances[neighbour], distances[curr] + time[neighbour-1]);
                    if(--indegrees[neighbour] == 0) q.offer(neighbour);
                }


            }
        }

        for (int distance :
                distances) {
            totalTime = Math.max(totalTime, distance);
        }

        return totalTime;
    }
}