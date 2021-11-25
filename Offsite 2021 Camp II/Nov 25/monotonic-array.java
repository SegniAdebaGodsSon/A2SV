// https://leetcode.com/problems/monotonic-array/

	class Solution {
    public boolean isMonotonic(int[] nums) {
        int len = nums.length;
        boolean inc=false, dec=false, eq=false;
        
        if(nums[0] < nums[len-1]) inc=true;
        else if(nums[0] > nums[len-1]) dec=true;
        else eq=true;
        
        
        for(int i=1; i<len; i++){
            if(inc && nums[i-1] > nums[i]) return false;
            if(dec && nums[i-1] < nums[i]) return false;
            if(eq && nums[i-1] != nums[i]) return false;
        }
        
        return true;
    }
}