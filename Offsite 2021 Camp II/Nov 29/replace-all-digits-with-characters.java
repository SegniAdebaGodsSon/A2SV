// https://leetcode.com/problems/replace-all-digits-with-characters/
class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(i % 2 == 0) sb.append(s.charAt(i));
            else sb.append(shift(s.charAt(i-1), Integer.parseInt(String.valueOf(s.charAt(i)))));
        }
        
        return sb.toString();
    }
    
    public char shift(char c, int x){
        return (char) (c + x);
    }
    
}