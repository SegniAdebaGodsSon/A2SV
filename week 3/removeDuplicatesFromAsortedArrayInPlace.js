/**
 * link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Solution 1
 * TC - O(n), n is the size of the array entered
 *      O(n) -  traversing the whole array
 *      O(m) -  popping duplicates
 *      O(1) -  swap function 
 * 
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    var swap = function(i, j){
        [nums[i], nums[j]] = [nums[j], nums[i]];
    }
    
    if(!nums.length) return;
    let len = nums.length, place=1;
    
    for(let i=1; i<nums.length; i++){
        if(nums[i] !== nums[place-1]){
            swap(i, place);
            place++;
        }
    }
    
    return place;
};