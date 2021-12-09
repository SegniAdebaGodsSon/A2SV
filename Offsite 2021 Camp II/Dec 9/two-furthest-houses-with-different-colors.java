// https://leetcode.com/problems/two-furthest-houses-with-different-colors/
class Solution {
    public int maxDistance(int[] colors) {
        int left = 0, right = colors.length-1;
        int max = -1;
        
        // left as pivot
        while(colors[left] == colors[right]) right--;
        max = Math.abs(right - left);
        right = colors.length-1;
        
        // right as pivot
        while(colors[left] == colors[right]) left++;
        
        return Math.max(Math.abs(right - left), max);
    }
}