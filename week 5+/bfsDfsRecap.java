import java.util.*;

class Scratch {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1, 3));
        adjList.put(1, Arrays.asList(0));
        adjList.put(2, Arrays.asList(3, 8));
        adjList.put(3, Arrays.asList(0, 4, 5, 2));
        adjList.put(4, Arrays.asList(3, 6));
        adjList.put(5, Arrays.asList(3));
        adjList.put(6, Arrays.asList(4,7));
        adjList.put(7, Arrays.asList(6));
        adjList.put(8, Arrays.asList(2));


        System.out.println("Adjacency List \n" + adjList);

        ArrayList<Integer> answers = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();

//        bfs(adjList, answers, visited);
//        for(int node : adjList.keySet()){
//            if(!visited.contains(node)){
//                dfs(adjList, answers, visited, node);
//            }
//        }


        System.out.println("Answers: " + answers);

    }

    public static void bfs(HashMap<Integer, List<Integer>> adjList, ArrayList<Integer> answers, HashSet<Integer> visited){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        while(queue.size() > 0){
            int currentNode = queue.poll();
            answers.add(currentNode);
            visited.add(currentNode);
            for(int neighbor : adjList.get(currentNode)){
                if(!visited.contains(neighbor))
                    queue.offer(neighbor);
            }

        }
    }

    public static void dfs(HashMap<Integer, List<Integer>> adjList, ArrayList<Integer> answers, HashSet<Integer> visited, int currentNode){
        answers.add(currentNode);
        visited.add(currentNode);
        for(int neighbor : adjList.get(currentNode)){
            if(!visited.contains(neighbor))
                dfs(adjList, answers, visited, neighbor);
        }

    }


}








































