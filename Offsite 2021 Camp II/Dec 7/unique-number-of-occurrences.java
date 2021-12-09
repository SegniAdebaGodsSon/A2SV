// https://leetcode.com/problems/unique-number-of-occurrences/
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        boolean[] counts = new boolean[arr.length+1];
        for(int a : arr){
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> c : count.entrySet()){
            if(counts[c.getValue()]) return false;
            else counts[c.getValue()] = true;
        }
        
    return true;        
    }
}