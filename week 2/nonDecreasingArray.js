/**
 * Solution 1
 * TC - O(n), n is the length of the array
 *      O(n) -  checking if a subArray is a non-decreasing array
 *      O(n) -  slicing an array
 * @param {number} nums 
 */

let checkPossibility = (nums) => {
    let checkNonDec = (subArr) => {
        for(let i=0; i<subArr.length-1; i++){
            if(!(subArr[i] <= subArr[i+1])) return i; 
        }
        return -1; // means it's non-decreasing
    }
    let count=0;
    let ind = checkNonDec(nums);
    let newArr1 = [... nums.slice(0, ind), ... nums.slice(ind+1)];
    let newArr2 = [... nums.slice(0,ind+1), ... nums.slice(ind+2)];
    if(checkNonDec(newArr1) !== -1 && checkNonDec(newArr2) !== -1){
        return false;
    }
    
    return true;
}
console.log(checkPossibility([1,1,1]));

