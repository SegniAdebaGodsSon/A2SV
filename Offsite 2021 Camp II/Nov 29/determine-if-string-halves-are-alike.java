// https://leetcode.com/problems/determine-if-string-halves-are-alike/
class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        int count1 = 0, count2 = 0;
        
        for(int i=0; i<len; i++){
            if(isVowel(s.charAt(i))){
                if(i<len/2) count1++;
                else count2++;
            }
        }
        
        return count1 == count2;
    }
    
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}