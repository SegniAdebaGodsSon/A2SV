/**
 * link: https://leetcode.com/problems/reorganize-string/
 * 
 * Solution 1 
 * TC - O(n^2), n is the length the @param {String} S
 *      O(n): adding unique chars in the @param {String} S to a hash/Map to track each charachters' count in a hashMap    
 *      O(n): getting the list of keys
 *      O(nlogn): to sort the keys based on repetition
 *      O(n*m): - n is the number of unique characters in the @param {String} S and m is their counts - placing each element in non-adjacent
 *              indexes in an array 
 *      O(n): Array.join('') method ??? not sure
 * 
 * Solution 2
 * TC - 
 * @param {string} S
 * @return {string}
 */

// Solution 1 - Sort
var reorganizeString1 = function(S) {
    let count = new Map();
    for(let char of S) count[char] = count[char] ? count[char]+1 : 1;       // populate the count Map/Hash
    let sortedByCount = Object.keys(count).sort((a, b) => count[b] - count[a]);
    let result=[];
    let index=0;

    for(let i=0; i<sortedByCount.length; i++){              // sorted unique characters in the string
        let occur = count[sortedByCount[i]];                //  occurance of the current character in the string
        if(occur > parseInt((S.length+1)/2)) return "";
        for(let j=0; j<occur; j++){
            if(index>=S.length) index=1;
            result[index] = sortedByCount[i];
            index += 2;
        }
    }

    return result.join('');
};

// Solution 2 - PQ
var reorganizeString = function(S){
    let hash = new Map(), pq = [];
    for(let s of S) hash.has(s) ? hash.set(s, hash.get(s)+1) : hash.set(s, 1);      // add each characters to a map with it's count
    hash.forEach((values, keys) => pq.push([keys, values]));                        
    pq.sort((a,b) => b[1]-a[1]);                                                    // sorted in an descending order

    let res = "";    
    while (pq.length != 0) {
        let lastChar = res[res.length - 1];
        let first = pq.shift();

        if(lastChar != first[0]) {
            res+=first[0];
            if (first[1]!=1) pq.push([first[0], first[1]-1]);
        } else {
            let second = pq.shift();
            if (second == null) return "";
            res+=second[0];
            pq.push(first);
            if (second[1]!=1) pq.push([second[0], second[1]-1]);
        }
        pq.sort((a,b)=>b[1]-a[1]);
    }
    return res;
}


console.log(reorganizeString("aab"));