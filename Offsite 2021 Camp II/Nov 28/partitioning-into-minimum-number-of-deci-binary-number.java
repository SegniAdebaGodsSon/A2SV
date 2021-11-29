// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

class Solution {
    public int minPartitions(String n) {
        int max = -1;
        for(int i=0; i<n.length(); i++){
            max = Math.max(Integer.parseInt(n.charAt(i)+""), max);
        }
        return max;
    }
}