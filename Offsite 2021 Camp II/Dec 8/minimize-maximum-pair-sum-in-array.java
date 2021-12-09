// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int left=0, right=nums.length - 1;
        int max = Integer.MIN_VALUE;
        
        while(right > left){
            max = Math.max(max, nums[left] + nums[right]);
            right--;
            left++;
        }
        
        return max;
    }
}