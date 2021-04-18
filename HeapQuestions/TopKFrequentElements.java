import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>( (x, y) -> y.getValue() - x.getValue() );
        int[] result = new int[k];

        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        pq.addAll(count.entrySet());


        for(int i=0; i<k; i++){
            result[i] = pq.poll().getKey();
        }

        return result;
    }
}