// https://leetcode.com/problems/product-of-array-except-self/
// prefixSum(product) from left and right
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefixSumFromLeft = new int[len];
        int[] prefixSumFromRight = new int[len];
        int[] ans = new int[len];
        
        
        for(int i=0; i<len; i++){
            if(i==0){
                prefixSumFromLeft[i] = nums[i];
                continue;
            }
            
            prefixSumFromLeft[i] = prefixSumFromLeft[i-1]*nums[i];
        }
        
        for(int i=len-1; i>=0; i--){
            if(i==len-1){
                prefixSumFromRight[i] = nums[i];
                continue;
            }
            prefixSumFromRight[i] = prefixSumFromRight[i+1]*nums[i];
        }
        
        for(int i=0; i<len; i++){
            int left = i > 0 ? prefixSumFromLeft[i-1] : 1;
            int right = i < len - 1 ? prefixSumFromRight[i+1] : 1;
            ans[i] = left * right;
        }
        
        return ans;

    }
}