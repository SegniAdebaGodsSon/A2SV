// https://leetcode.com/problems/find-eventual-safe-states/

// TOPOLOGICAL SORT using dfs -- no eventual safe node if it exists in a loop

class State{
    boolean PROCESSING = false;
    boolean PROCESSED = false;
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        
        State[] state = new State[n];
        boolean[] isInCycle = new boolean[n];
        for(int i=0; i<n; i++) state[i] = new State();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            isInCycle[i] = !DFS_topological_sort(graph, i, state);
        }
        
        for(int i=0; i<n; i++){
            if(!isInCycle[i]) ans.add(i);
        }
        
        
        return ans;
    }
    
    
    public boolean DFS_topological_sort(int[][] graph, int node, State[] state){
        state[node].PROCESSING = true;
        
        for(int neighbour : graph[node]){
            if(state[neighbour].PROCESSED) continue;
            if(state[neighbour].PROCESSING) return false;
            
            if(!DFS_topological_sort(graph, neighbour, state)){
                return false;
            }
        }
        
        
        state[node].PROCESSED = true;
        state[node].PROCESSING = false;
        return true;
    }
    
    
}