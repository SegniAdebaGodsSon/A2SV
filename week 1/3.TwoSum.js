/**
- link: https://leetcode.com/problems/two-sum/
- Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

-    2 <= nums.length <= 103
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
 */

 /**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

 // Approach 1: Brute Force
var twoSum = function(nums, target) {
    let answer = [];
    for(i=0; i<nums.length-1; i++){
        for(j=i+1; j<nums.length; j++){
            if(nums[i] + nums[j] === target) answer = [i,j];
        }
    }
    return answer;    
};

let a = [2,7,11,15];
let b = [3,2,4];
let c = [3,3];

// console.log(twoSum(a, 9));
// console.log(twoSum(b, 6));
// console.log(twoSum(c, 6));
// console.log(twoSum([3,2,3], 6));


// Approach 2: Two-pass Hash Table/ Map
var twoSum2 = function(nums, target){
    let map = new Map();
    for(i=0; i<nums.length; i++){
        map.set(nums[i], i);
    }

    for(i=0; i<nums.length; i++){
        let diff = target - nums[i];
        if(map.has(diff) && (map.get(diff) !== i)){
            return [i, map.get(diff)]
        }
    }

    return [];
}

console.log(twoSum2(a, 9));
console.log(twoSum2(b, 6));
console.log(twoSum2(c, 6));
console.log(twoSum2([3,2,3], 6));


