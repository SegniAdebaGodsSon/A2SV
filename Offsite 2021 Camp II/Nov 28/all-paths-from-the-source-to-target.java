// https://leetcode.com/problems/all-paths-from-source-to-target/

class Solution {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths  = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(), allPaths);

        // System.out.println(allPaths);
        return allPaths;
    }

    public static void dfs(int[][] graph, int curr, List<Integer> path, List<List<Integer>> allPaths){
        List<Integer> pathCopy = new ArrayList<>(path);
        pathCopy.add(curr);
        if(curr == graph.length-1){
            allPaths.add(pathCopy);
            return;
        }

        for (int neighbor : graph[curr]) {
            dfs(graph, neighbor, pathCopy, allPaths);
        }
    }
}