// https://leetcode.com/problems/loud-and-rich/
class Solution {
    public static HashMap<Integer, List<Integer>> generateAdjList(int n, int[][] richer){
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<n; i++) adjList.put(i, new ArrayList<>());
        for(int[] relation : richer) adjList.get(relation[1]).add(relation[0]);
        return adjList;
    }


    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int nodes = quiet.length;
        int[] ans = new int[nodes];
        HashMap<Integer, List<Integer>> adjList = generateAdjList(nodes, richer);
        int[] inDegrees = new int[nodes];
        for (int[] rich : richer) inDegrees[rich[0]]++;

        // System.out.println(adjList);

        List<Integer> sorted = topological_sort(adjList, inDegrees);
//        System.out.println("Sorted: " + sorted);

        for (int i = 0; i < nodes; i++) {
            if(adjList.get(i).size() == 0) ans[i] = i;
        }
        for (int i = sorted.size() - 1; i >= 0; i--) {
            int curr = sorted.get(i);
            ans[curr] = curr;
            for (int neighbour : adjList.get(curr)) {
                if(quiet[ans[neighbour]] < quiet[ans[curr]])
                    ans[curr] = ans[neighbour];
            }


        }

//        System.out.println("My ans: " + Arrays.toString(ans));
        return ans;

    }

    public static List<Integer> topological_sort(HashMap<Integer, List<Integer>> adjList, int[] inDegrees){
        List<Integer> sorted = new ArrayList<>();

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()){
            int curr = q.poll();
            sorted.add(curr);
            for(int neighbour : adjList.get(curr)){
                if(--inDegrees[neighbour] == 0) q.offer(neighbour);
            }
        }
        return sorted;
    }

}