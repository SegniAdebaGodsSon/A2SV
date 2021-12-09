// https://leetcode.com/problems/non-overlapping-intervals/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals) list.add(interval);
        
        list.sort((a, b) -> (Integer.compare(a[1], b[1]) == 0 ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])));
        
        int[] correct = null;
        int removed = 0;
        for(int[] interval : list){
            if(correct == null){
                correct = interval;
                continue;
            } 
            
            if(interval[0] >= correct[1]){
                correct = interval;
            }else{
                removed++;
            }
        }
        
        return removed;
    }
}