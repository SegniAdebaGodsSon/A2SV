// https://leetcode.com/problems/evaluate-division/

// map string variables into integers to work with matrixes(since I'm using Floyd-Warshall algorithm)
// go through the algorithm only update if the weight of a connection between neighbours of a node is Infinity
// unlike normal shortest path the mirror value on the matrix is 1/val of val
// TC: O(n^3) ... the Floyd-Warshall algorithm is the bottleneck
// SC: O(n*n) ... the matrix is the bottle neck


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        HashMap<String, Integer> mapping = nodesAsInt(equations);
        int n = mapping.size();
        
        
        double[][] graph = FloydWarshall(n, equations, values, mapping);
        
        // printGraph(graph);
        
        
        int queryInd = 0;
        for(List<String> query : queries){
            if(mapping.containsKey(query.get(0)) && mapping.containsKey(query.get(1))){ 
                int i = mapping.get(query.get(0)), j = mapping.get(query.get(1));
                ans[queryInd] = graph[i][j] == Integer.MAX_VALUE ? -1 : graph[i][j];
            }else{
                ans[queryInd] = -1;
            }
            queryInd++;
        }
        
        return ans;
    }
    
    public HashMap<String, Integer> nodesAsInt(List<List<String>> equations){
        HashMap<String, Integer> map = new HashMap<>();
        int num = 1;
        for(List<String> eq : equations){
            if(!map.containsKey(eq.get(0))){
                map.put(eq.get(0), num);
                num++;
            }
            
            if(!map.containsKey(eq.get(1))){
                map.put(eq.get(1), num);
                num++;
            }
        }
        return map;
    }

    public double[][] FloydWarshall(int n, List<List<String>> equations, double[] values, HashMap<String, Integer> mapping){
        double[][] graph = new double[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j) graph[i][j] = 1;
                else{
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int i=0; i<equations.size(); i++){
            // q / d
            List<String> curr = equations.get(i);

            int q = mapping.get(curr.get(0)), d = mapping.get(curr.get(1));
            graph[q][d] = values[i];
            graph[d][q] = 1 / values[i];
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(graph[i][k] < Integer.MAX_VALUE && graph[j][k] < Integer.MAX_VALUE && graph[i][j] == Integer.MAX_VALUE){
                        graph[i][j] = graph[i][k] * graph[k][j];
                        graph[j][i] = 1 / graph[i][j];
                    }
                }
            }
        }
        
        
        
        return graph;
        
    }
    
    public void printGraph(double[][] graph){
        for(int i=1; i<graph.length; i++){
            System.out.println(Arrays.toString(Arrays.copyOfRange(graph[i], 1, graph.length)));
        }
    }

    public double[][] floydWarshall(double[][] graph){
        return graph;
    }
}