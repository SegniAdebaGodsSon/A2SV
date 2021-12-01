// https://leetcode.com/problems/truncate-sentence/

import java.util.StringTokenizer;
class Solution {
    public String truncateSentence(String s, int k) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        
        while(k-- > 0){
            sb.append(st.nextToken());
            if(k > 0) sb.append(" ");
        }

        return sb.toString();
    }
}