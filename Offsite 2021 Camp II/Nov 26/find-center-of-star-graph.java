// https://leetcode.com/problems/find-center-of-star-graph
class Solution {
    public int findCenter(int[][] edges) {
        int len = edges.length;
        if(edges[0][0] == edges[len-1][0] || edges[0][0] == edges[len-1][1]) return edges[0][0];
        else return edges[0][1];
    }
}