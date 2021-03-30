import java.util.*;

class Solution {
    public static int minimumTotal(List<List<Integer>> triangle) {
        HashMap<String, Integer> adjList = new HashMap<>();
        return topDown(adjList, triangle, new int[]{0, 0});
//        return bottomUp(triangle);
    }

    public static int topDown(HashMap<String, Integer> adjacency, List<List<Integer>> triangle, int[] position){
        // System.out.println(Arrays.toString(position));
        if(position[0] == triangle.size()-1){
            // System.out.println("Returned at " + Arrays.toString(position) + " -> " + triangle.get(position[0]).get(position[1]));
            return triangle.get(position[0]).get(position[1]);
        }
        if(adjacency.containsKey(Arrays.toString(position)))
            return adjacency.get(Arrays.toString(position));
        // System.out.println("curr -> " + triangle.get(position[0]).get(position[1]) + "   left-child -> " + Arrays.toString(new int[]{position[0] + 1, position[1]}) +  "   right-child -> " + Arrays.toString(new int[]{position[0] + 1, position[1] + 1}));

        int min = triangle.get(position[0]).get(position[1]) +  Math.min( topDown(adjacency, triangle, new int[]{position[0] + 1, position[1]}), topDown(adjacency, triangle, new int[]{position[0] + 1, position[1] + 1}) );
        adjacency.put(Arrays.toString(position), min);

        return min;
    }


    public static int bottomUp(List<List<Integer>> triangle){
        int size = triangle.size();
        int[] processedLevel = new int[size];
        int count = 0;
        for(int value : triangle.get(size-1)){
            processedLevel[count] = value;
            count++;
        }

        for(int i=size-2; i>=0; i--){
            int sizeSec = triangle.get(i).size();
            int[] updatedVersion = new int[sizeSec];
            for(int j=0; j<sizeSec; j++){
                System.out.println("(i: " + i + " j: " + j + ")." + triangle.get(i).get(j) + "  -> " + processedLevel[j] + ", " + processedLevel[j+1]);
                updatedVersion[j] = triangle.get(i).get(j) + Math.min(processedLevel[j], processedLevel[j+1]);
            }
            processedLevel = updatedVersion;
            System.out.println("level -> " + Arrays.toString(processedLevel));
        }
        return processedLevel[0];
    }


}