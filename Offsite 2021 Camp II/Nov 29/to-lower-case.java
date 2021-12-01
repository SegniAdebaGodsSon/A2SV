// https://leetcode.com/problems/to-lower-case/

class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            sb.append((isUppercase(curr) ? (char) (curr + 32) : (char) curr));
        }
        
        return sb.toString();
    }
    
    public boolean isUppercase(char character){
        return 65 <= character && character <= 90;
    }
}