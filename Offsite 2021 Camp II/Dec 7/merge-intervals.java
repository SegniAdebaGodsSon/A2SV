// https://leetcode.com/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals) list.add(interval);
        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ansList = new ArrayList<>();
        
        ansList.add(list.get(0));
        for(int i=1; i<list.size(); i++){
            int[] prev = ansList.get(ansList.size() - 1);
            int[] curr = list.get(i);
            if(prev[1] < curr[0]) ansList.add(curr);
            else{
                int[] newInt = {prev[0], Math.max(prev[1], curr[1])};
                ansList.remove(ansList.size()-1);
                ansList.add(newInt);
            }
        }
        
        int[][] ans = new int[ansList.size()][2];
        int i=0;
        for(int[] interval : ansList){
            ans[i][0] = interval[0];
            ans[i][1] = interval[1];
            i++;
        }
        return ans;
    }
}