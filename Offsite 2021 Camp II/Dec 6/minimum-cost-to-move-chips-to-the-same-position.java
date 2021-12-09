// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
class Solution {
    public int minCostToMoveChips(int[] positions) {
        int evenCount = 0, oddCount = 0;
        for(int position : positions){
            if(position % 2 == 0) evenCount++;
            else oddCount++;
        }
        
        return Math.min(evenCount, oddCount);
    }
}