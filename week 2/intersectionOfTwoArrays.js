/**
 * link: https://leetcode.com/problems/intersection-of-two-arrays
 * 
 * solution 1 
 * TC -  O(2n+m) = O(n+m) LINEAR , where n and m are arrays' lengths. 
 *      O(n) time is used to convert uniqueIntersection into set, O(m) time is used to convert uniqueIntersection,
 *      O(n) iterating through nums1 with the filter method and contains/in operations are O(1) in the average case.
 * 
 * solution 2 
 * TC - O(n+m+mlog(n)) = O(n+m) LINEAR, where n and m are arrays' lengths. 
 *      O(n) to iterate the array to populate the set, O(mlog(m)) JS sort(quick sort), O(m) iterating through the second array
 *      O(1) has/set map methods
 * 
 * solution 3
 * TC - O(n+m) , where n and m are arrays' lengths. 
 *      O(n) converting the first array to a set, O(m) converting the second array to set
 *      O(k) converting a set to an array, O(k) iterating over an array, O(m)- worst case - method on a set2 
 * 
 * @param {number[]} nums1 
 * @param {number[]} nums2 
 */

// solution 1
var intersection = function(nums1, nums2){
    let intersections = nums1.filter(num => nums2.includes(num));       // filter the intersection
    const uniqueIntersection = new Set(intersections);                  // get only the unique values without repetition 
    return [...uniqueIntersection];                                     // return it as an array 
}

// solution 2
var intersection2 = function(nums1, nums2){
    let uniqueNum1Members = new Map();
    let intersections = []; 
    nums1.forEach(element => {
         if(!uniqueNum1Members.has(element)){
             uniqueNum1Members.set(element, "");
         }
     });
    
     // we can also use Set() to only extract unique values
    nums2 = nums2.sort((a,b) => b-a);
    nums2.forEach((element, index) => {
        let prev = index > 0 ? nums2[index-1]: null;
        if(uniqueNum1Members.has(element) && element !== prev){
            intersections.push(element);
        } 
    });
    
    return intersections;
}

// solution 3 - almost same with solution solution 1 but is faster
var intersection3 = function(nums1, nums2){
    const set1 = new Set(nums1);
    const set2 = new Set(nums2);
    return [...set1].filter(n => set2.has(n));
}