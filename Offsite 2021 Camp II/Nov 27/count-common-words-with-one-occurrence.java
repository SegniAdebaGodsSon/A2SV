// https://leetcode.com/problems/count-common-words-with-one-occurrence/

class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> count1 = new HashMap<>();
        HashMap<String, Integer> count2 = new HashMap<>();
        
        for(String word1 : words1) count1.put(word1, count1.getOrDefault(word1, 0) + 1);
        for(String word2 : words2) count2.put(word2, count2.getOrDefault(word2, 0) + 1);
        
        int count = 0;
        
        for(String word : words1){
            if(count1.containsKey(word) && count2.containsKey(word) && count1.get(word) == 1 && count2.get(word) == 1) count++;
        }
        return count;
    }
}