// https://leetcode.com/problems/is-graph-bipartite/submissions/
// color a node BLUE/RED and color it's neighbours and opposite color RED/BLUE
class Solution {
    final int BLUE = 1;
    final int RED = 2;
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        
        for(int i=0; i<len; i++){
            if(!DFS(graph, i, colors, BLUE)) return false;
            colors = new int[len];
        }
    
        return true;
        
    }

    public boolean DFS(int[][] graph, int currNode, int[] colors, int color){
        colors[currNode] = color;
        int neighbourColor = color == BLUE ? RED : BLUE;
        
        for(int neighbour : graph[currNode]){
            if(colors[neighbour] == color) return false;
            if(colors[neighbour] == neighbourColor) continue;
            boolean neighbourResult = DFS(graph, neighbour, colors, neighbourColor);
            if(!neighbourResult) return false;
        }
        
        return true;
    }
}