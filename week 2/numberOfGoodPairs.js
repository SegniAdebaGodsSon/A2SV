/**
 * link: https://leetcode.com/problems/number-of-good-pairs/
 * 
 * solution 1
 *TC -  O(n), n is the length of the input array
 *      O(n) for populating the count map, O(n) to calculate the total good pairs for given count 
 *      O(n) to find the whole number good pairs   
 * 
 * 
 * @param {number[]} nums
 * @return {number}
 */

// solution
var numIdenticalPairs = function(nums) {
    let count = new Map();
    let numOfGoodPairs = 0;
    nums.forEach(num => {
       if(!count.has(num)){
           count.set(num, 1);
       }else{
           count.set(num, count.get(num)+1);
       }
          
    });
    
    var numOfGoodPair = function(cnt){
        let result=0;
        for(let i=0; i<cnt;i++){
            result+=i;
        }
        return result;
    }
    
    for(let [key, val] of count){
        if(val>1){
            numOfGoodPairs += numOfGoodPair(val);
        }
    }
    return numOfGoodPairs;
};