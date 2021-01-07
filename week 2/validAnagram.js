/**
 * link: https://leetcode.com/problems/valid-anagram
 * 
 * solution 1
 * TC - O(n+m) LINEAR,  where n and m are strings' lengths.
 *      O(n) to O(n*delimiter_length) and O(m) to O(m*delimiter_length) for splitting, O(nlogn)&O(mlogm) for sorting
 *      O(n) ??? join method
 * 
 * solution 2
 * TC - O(n+m) LINEAR, where n and m are strings' lengths.
 *      O(n) & O(m) creating a map of characters in the string with their counts, O(n) - (m==n same size) - to check equality
 * 
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */

 // solution 1  => minimal code
var isAnagram1 = function(s, t){
     return s.split("").sort().join("") === t.split("").sort().join("") 
}

 // solution 2 => faster than solution 1
var isAnagram2 = function(s,t){
    var count = function(str){
        let sCount = new Map();
        for (let i = 0; i < str.length; i++) {
            const char = str[i];
            if(!sCount.has(char)){
                sCount.set(char, 0);
            }else{
                sCount.set(char, sCount.get(char)+1);
            }
        }
        return sCount
    }

    let sCount = count(s);
    let tCount = count(t);

    if(sCount.size !== tCount.size) return false;

    let temp;
    for(let [key, val] of sCount){
        temp = tCount.get(key);
        
        // in cases of an undefined value, make sure the key actually exists on the object, because undefined is a valid value in js maps
        if(temp !== val || (temp === undefined && !tCount.has(key))){
            return false;
        }
    }
    return true;
}

