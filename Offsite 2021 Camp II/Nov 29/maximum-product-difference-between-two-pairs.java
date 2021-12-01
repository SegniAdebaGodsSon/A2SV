// https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
class Solution {
    public int maxProductDifference(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len-2] * nums[len-1] - nums[0] * nums[1];
    }
}