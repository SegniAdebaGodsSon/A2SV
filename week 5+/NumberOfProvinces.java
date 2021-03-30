import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
        int[][] input2 = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        int result= findCircleNum2(input2);
        System.out.println(result);



    }

    public static int findCircleNum2(int[][] isConnected) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        // create the adjacency list
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j < isConnected[i].length; j++){
                if(isConnected[i][j] == 0) continue;
                ArrayList<Integer> val = adjList.getOrDefault(i, new ArrayList<Integer>());
                val.add(j);
                adjList.put(i, val);
            }
        }
        for(int i=0; i<isConnected.length; i++){
            if(!visited[i]){
                dfs2(visited, adjList, i);
                count++;
            }
        }
        return count;
    }

    public static void dfs2(boolean[] visited, HashMap<Integer, ArrayList<Integer>> adjList, int person){
        visited[person] = true;
        for(int j : adjList.get(person)){
            if(visited[j]) continue;
            dfs2(visited, adjList, j);
        }
    }


    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];    // visited[i] means if i-th person is visited in this algorithm
        int count = 0;
        for(int i=0; i<isConnected.length; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int person){
        for(int other=0; other < isConnected.length; other++){
            if(isConnected[person][other] == 1 && !visited[other]){
                visited[other] = true;                            // We found an unvisited person in the current friend cycle
                dfs(isConnected, visited, other);
            }
        }
    }
}