/**
 * link: https://leetcode.com/problems/largest-perimeter-triangle/
 * 
 * solution 1
 * TC - O(nlogn) worst case, n is the length of the A, array
 *      O(nlogn) for sorting the array, O(n)/O(n-2) traversing, O(1) equality checking
 * 
 * @param {number[]} A
 * @return {number}
 */

// solution 1
var largestPerimeter = function(A) {
    A = A.sort((a,b) => a-b);

    for(let i = A.length - 1; i >= 2; i--){
        if((A[i] < (A[i-1]) + A[i-2])){
            return A[i] + A[i-1] + A[i-2];
        }
    }
    return 0;
};

console.log(largestPerimeter([1,2,1]))