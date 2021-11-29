// https://leetcode.com/problems/find-target-indices-after-sorting-array/submissions/

// solution #1
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target) ans.add(i);
        }
        return ans;
    }
}




// solution #2
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int numsBeforeTarget = 0;
        int targetCount = 0;
        List<Integer> ans = new ArrayList<>();
        
        for(int num : nums){
            if(num < target) numsBeforeTarget++;
            if(num == target) targetCount++;
        }
        
        for(int i=numsBeforeTarget; i<targetCount+numsBeforeTarget; i++){
            ans.add(i);
        }
        return ans;
    }
}