// https://leetcode.com/problems/house-robber/

class Solution {
    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] memo = nums.clone();
        int len = nums.length;

        for (int i=0; i<len; i++){
            int ll = i - 3 > -1 ? memo[i-3] : 0;
            int l = i - 2 > -1 ? memo[i-2] : 0;
            memo[i] = memo[i] + Math.max(ll, l);
        }
        return Math.max(memo[len-1], memo[len-2]);
    }
    
   
}