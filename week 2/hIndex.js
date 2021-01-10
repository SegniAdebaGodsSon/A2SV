/**
 * link: https://leetcode.com/problems/h-index/
 * 
 * Solution 1
 * TC - O(n), n is the lenght of the parameter - citations
 *      O(n) for populating the map, O(n) for finding the h-index
 * 
 * Solution 2
 * TC - O(n), n is the length of the parameter - citations
 *      O(n) creating the new count array for count sorting, O(n) finding  
 * @param {number[]} citations
 * @return {number}
 */

// Solution 1
function hIndex(citations){
    let map={} , len=citations.length, max=0;
    citations.forEach(c => map[c] = map[c] ? map[c]+1 : 1); // populate the map
    for(let i=0; i<=len; i++){
        max = Math.max(max, i);
        len -= map[i] ? map[i] : 0; 
    }  

    return max;
}

// Solution 2
function hIndex2(citations){
    let len = citations.length
    let count = new Array(len+1).fill(0);
    for(let i=0; i<len; i++){
        if(citations[i] > len) count[len]++;
        else count[citations[i]]++;
    }
    
    for(let i=len; i>0; i--){
        if(count[i] >= i) return i;
        count[i-1] += count[i];
    }
    return 0
}


console.log(hIndex2([3,0,6,1,5]))