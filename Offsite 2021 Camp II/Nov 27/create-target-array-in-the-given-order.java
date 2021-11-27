// https://leetcode.com/problems/create-target-array-in-the-given-order/
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<len; i++){
            result.add(index[i], nums[i]);
        }
        
        int[] ans = new int[result.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
}