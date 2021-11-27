// https://leetcode.com/problems/goal-parser-interpretation/

class Solution {
    public String interpret(String command) {
        if(command.equals("G")) return command;
        int len = command.length();
        StringBuilder sb = new StringBuilder();
        int ptr = 0;
        while(ptr<len){
            char currChar = command.charAt(ptr);
            char nextChar = ptr == len-1 ? '3' : command.charAt(ptr+1);
            
            if(currChar == 'G'){
                sb.append('G');
                ptr++;
            }else if(currChar == '('){
                if(nextChar == ')'){
                    sb.append('o');
                    ptr+=2;
                }
                
                if(nextChar == 'a'){
                    sb.append('a').append('l');
                    ptr+=3;
                }
            }else{
                ptr++;
            }
        }
        return sb.toString();
    }
}