// https://leetcode.com/problems/path-with-maximum-probability/

// BFS / Belmann Ford approach
class Node{
    int node;
    double cost;
    Node(int node, double cost){
        this.node = node;
        this.cost = cost;
    }
}


class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, List<Node>> adjList = generateAdjList(n, edges, succProb);
        double[] probability = new double[n];
        Arrays.fill(probability, 0);
        probability[start] = 1;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(start, 1));
        
        // u - source
        // v - target
        // u-v edge
        while(!q.isEmpty()){
            Node u = q.poll();
            
            for(Node v : adjList.get(u.node)){
                if(probability[v.node] < probability[u.node] * v.cost){
                    probability[v.node] = probability[u.node] * v.cost;
                    q.offer(new Node(v.node, probability[v.node]));
                }
            }
        }
        
        return probability[end];
    }
    
    public HashMap<Integer, List<Node>> generateAdjList(int n, int[][] edges, double[] succProb){
        HashMap<Integer, List<Node>> adjList = new HashMap<>();
        for(int i=0; i<n; i++) adjList.put(i, new ArrayList<Node>());
        
        int ind=0;
        for(int[] edge : edges){
            adjList.get(edge[0]).add(new Node(edge[1], succProb[ind]));            
            adjList.get(edge[1]).add(new Node(edge[0], succProb[ind]));
            ind++;
        }
        
        return adjList;
    }
    
    
}