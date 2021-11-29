// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

// solution #1
class Solution {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] ans = new int[len];
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                ans[i] += boxes.charAt(j) == '1' ? Math.abs(i - j) : 0;
            }
        }
        
        return ans;
    }
}