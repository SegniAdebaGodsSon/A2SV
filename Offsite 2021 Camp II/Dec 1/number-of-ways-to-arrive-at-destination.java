// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

// Dijkstra + another array to track how many times we reach the same node with the same distance as before


class Node{
    int node;
    long cost;
    Node(int node, long cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "node=" + node +
                ", cost=" + cost +
                '}';
    }
}

class Solution {
    final int mod = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        List<Node>[] adjList = generateAdjList(n, roads);
        // System.out.println(Arrays.toString(adjList));
        return dijkstra(n, adjList);
    }
    
    public List<Node>[] generateAdjList(int n, int[][] roads){
        List<Node>[] adjList = new ArrayList[n];
        for(int i=0; i<n; i++) adjList[i] = new ArrayList();
        for(int[] road : roads){
            adjList[road[0]].add(new Node(road[1], road[2]));
            adjList[road[1]].add(new Node(road[0], road[2]));
        }
    
        return adjList;
    }
    
    public int dijkstra(int n, List<Node>[] adjList){
        boolean[] processed = new boolean[n];
        int[] ways = new int[n];
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        
        distance[0] = 0;
        ways[0] = 1;
        
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        q.offer(new Node(0, 0));
        
        while(!q.isEmpty()){
            Node u = q.poll();
            processed[u.node] = true;
            for(Node v : adjList[u.node]){
                if(processed[v.node]) continue;
                if(distance[v.node] > distance[u.node] + v.cost){           // new short distance to an unprocessed node found
                    distance[v.node] = distance[u.node] + v.cost;
                    q.offer(new Node(v.node, distance[v.node]));
                    ways[v.node] = ways[u.node];
                }else if(distance[v.node] == distance[u.node] + v.cost){    // another way of reaching a node with the same(minimum cost)
                    ways[v.node] = (ways[v.node] + ways[u.node]) % mod;
                }     
            }
        }
        System.out.println(Arrays.toString(distance));
        return ways[n-1];
    }
}