/**
 * link: https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * 
 * SOLUTION 1
 * TC - 
 * 
 * 
 * SOLUTION 2
 * TC - 
 * 
 * @param {number[]} nums
 * @return {number[]}
 */
var frequencySort = function(nums) {
    let hashMap = new Map();
    let max = -1;
    nums.forEach(num => {
        if(!hashMap.has(num)){
            hashMap.set(num, 1);  
            if(max < 1) max = 1;
       }else{
           hashMap.set(num, hashMap.get(num)+1);
           if(hashMap.get(num) > max) max = hashMap.get(num);
       } 
    });
    
    
    let entries = Array.from(hashMap.entries()).sort((a, b) => a[0] - b[0]);    // sort the entries based on the values
    let countingSort = new Array(max+1).fill().map(e => []);                      // create 2D array to store the values at indexed arrays
    console.log(countingSort);
    for(let [value, count] of entries){
        if(!countingSort[count]){
            countingSort[count].push(value)    
        }else{
            countingSort[count].unshift(value);
        }
    }
    console.log('counting sort: ', countingSort)
    let result = [];
    countingSort.forEach((val, ind)=>{
        for(let i=0; i<val.length; i++){
            for(let j=0; j<ind;j++){
                result.push(val[i])
            }
        }
    });    
    
    return result;
};






var frequencySort2 = function(nums) {
    const map = new Map()
    for(let n of nums){
      map.set(n, (map.get(n) || 0)+1)
    }
    return nums.sort((a,b)=>{
      if(map.get(a) === map.get(b)){
        return b-a      // decreasing order of the number if two nums' count is same
      }else{
        return map.get(a) - map.get(b) // Increasing order of the count if the numbers are not equal
      }
    })
  };