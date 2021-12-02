// https://leetcode.com/problems/split-a-string-in-balanced-strings/
class Solution {
    public int balancedStringSplit(String s) {
        int maxBalancedStrings = 0;
        int Rs = 0, Ls = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'R') Rs++;
            if(s.charAt(i) == 'L') Ls++;
            
            if(Rs > 0 && Ls > 0 && Ls == Rs){
                maxBalancedStrings++;
                Rs = 0;
                Ls = 0;
            }
        }
        return maxBalancedStrings;
    }
}