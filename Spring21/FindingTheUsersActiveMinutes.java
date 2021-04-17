import java.util.*;

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> countUnique = new HashMap<>();
        int[] result = new int[k];

        for(int[] log : logs)
        {
            HashSet<Integer> value = countUnique.getOrDefault(log[0], new HashSet<>());
            value.add(log[1]);
            countUnique.put(log[0], value);
        }

        for(Map.Entry<Integer, HashSet<Integer>> entry : countUnique.entrySet())
        {
            result[entry.getValue().size() - 1]++;
        }

        return result;
    }
}