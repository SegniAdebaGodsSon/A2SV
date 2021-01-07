/**
 * link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses
 * 
 * solution 1
 * TC - O(n), n is the size of the string passed through
 *      O(n) for travesting, O(1) checking equality
 * 
 * @param {string} s
 * @return {number}
 */
var maxDepth = function(s) {
    s = s.split("");
    let count = 0;
    let depth = 0;
    s.forEach(element => {
        if(element === "("){
            count++;
        }else if(element === ")"){
            depth = Math.max(count , depth);
            count--;
        }
    });
    return depth;
};