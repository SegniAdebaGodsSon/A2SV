// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        
        for(int[] point : points){
            if(merged.isEmpty() || merged.getLast()[1] < point[0]) merged.add(point);
            else{
                merged.getLast()[0] = point[0];
                merged.getLast()[1] = Math.min(merged.getLast()[1], point[1]);
            }
        }
            
        return merged.size();
    }
}