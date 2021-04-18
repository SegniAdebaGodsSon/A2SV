import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((s1, s2) -> {
            int comp = s2.getValue().compareTo(s1.getValue());
            if(comp == 0) return s1.getKey().compareTo(s2.getKey());
            return comp;
        });

        for(String word : words){
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        pq.addAll(count.entrySet());

        List<String> result = new ArrayList<String>();
        for(int i=0; i<k; i++){
            result.add(pq.poll().getKey());
        }

        return result;

    }
}