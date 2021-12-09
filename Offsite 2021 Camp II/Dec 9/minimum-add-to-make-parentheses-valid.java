// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
class Solution {
    public int minAddToMakeValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int closingCount = 0;
        
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()) closingCount++;
                else stack.pop();
            }
        }
        return stack.size() + closingCount;
    }
}