
import java.util.*;
class solution{
    public static void main(String[] args){
        int[] managers = {2, 2, 4, 6, -1, 4, 4, 5};
        int[] informTime = {0, 0, 4, 0, 7, 3, 6, 0};
        int headId = 4;

//        int[] managers = {1, 2, 3, 4, 5, 6, -1};
//        int[] informTime = {0, 2, 1 ,3, 1, 3, 22};
//        int headId = 6;

        System.out.println(timeToInformAll(managers, informTime, headId));
    }

    public static int timeToInformAll(int[] managers, int[] informTime, int headId){
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        // construct the adjacency list and the inform time map for O(1) lookup
        for(int i = 0; i < managers.length; i++){
            ArrayList<Integer> subordinates = adjList.getOrDefault(managers[i], new ArrayList<Integer>());
            subordinates.add(i);
            adjList.put(managers[i], subordinates);
        }
        System.out.println("Adjacency List: " + adjList);
        return informDfs(adjList, headId, informTime, informTime[headId]);
    }

    public static int informDfs(HashMap<Integer, ArrayList<Integer>> adjList, int currEmp, int[] informTime, int time){
        System.out.println("ID: " + currEmp + "\n" + "time: " + time + "\n");
        if(informTime[currEmp] == 0) return time;
        int max =time;
        for(int subOrd : adjList.get(currEmp)){
            int temp = informDfs(adjList, subOrd, informTime,time + informTime[subOrd]);
            if(temp > max) max = temp;
        }
        return max;
    }
}
