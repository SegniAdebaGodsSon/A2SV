// https://leetcode.com/problems/partition-labels/

class Solution {
    public List<Integer> partitionLabels(String s) {
        int len = s.length();
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> last = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i=len-1; i>=0; i--){
            if(!last.containsKey(chars[i])) last.put(chars[i], i);
        }
        
        // System.out.println(last);
        int left = 0, right = 0;
        
        while(right < len){
            right = last.get(chars[left]);
            int maxLast = left;
            for(int i=left; i<right; i++){ 
                maxLast = Math.max(maxLast, last.get(chars[i]));
                right = Math.max(right, maxLast);
            }
            
            ans.add(maxLast - left + 1);
            left = maxLast+1;
            right = left;
        }
        
        
        return ans;
    }
}