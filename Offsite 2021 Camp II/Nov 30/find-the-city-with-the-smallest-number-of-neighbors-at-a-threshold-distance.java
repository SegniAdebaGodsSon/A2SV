// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        long[][] shortestPaths = floydWarshall(n, edges);
        HashMap<Integer, Integer> withinReach = new HashMap<>();
        for(int i=0; i<n; i++) withinReach.put(i, 0);
        
        int minNeighbours = Integer.MAX_VALUE;
        for(int node=0; node<n; node++){
            for(int neighbour=0; neighbour<n; neighbour++){
                if(node == neighbour) continue;
                if(shortestPaths[node][neighbour] <= distanceThreshold){
                    withinReach.put(node, withinReach.get(node) + 1);
                }
            }
            minNeighbours = Math.min(minNeighbours, withinReach.get(node));
        }
        
        // System.out.println(Arrays.deepToString(shortestPaths));
        // System.out.println(withinReach);
         // System.out.println(minNeighbours);

        
        int ans = 0;
        for(int i=0; i<n; i++){
            if(withinReach.get(i) == minNeighbours){
                ans = i;
            }
        }
        
        return ans;
    }
    
    
    public long[][] floydWarshall(int n, int[][] edges){
        long[][] shortestPaths = new long[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j) shortestPaths[i][j] = Integer.MAX_VALUE;
            }
        }    
        
        for(int[] edge : edges){
            shortestPaths[edge[0]][edge[1]] = edge[2];            
            shortestPaths[edge[1]][edge[0]] = edge[2];
        }
    
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    shortestPaths[i][j] = Math.min(
                        shortestPaths[i][j],
                        shortestPaths[i][k] + shortestPaths[k][j]);
                }
            }
        }
        
        return shortestPaths;
    }
}