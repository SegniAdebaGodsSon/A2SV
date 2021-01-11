/**
 * 
 *  *********       Refer to the <RE-ORGANIZE STRING> problem, same solutions       *************
 * 
 * link: https://leetcode.com/problems/distant-barcodes/
 * 
 * approach 1
 * TC - O(nlogn), n is the size of t@param {number[]} barcodes
 *      O(n)    - keeping count of each codes int the parameter @param barcodes
 *      O(n)    - converting an iterable object literal into an array using 'rest' shortcut used in destructuring
 *      O(nlogn)- sort the array of tuples returned 
 *      O(n^2)    - iterating over each unique values + their repetition
 * 
 * approach 2
 * TC - O(nlogn), n is the length the @param {number[]} barcodes
 *      O(n)    - populate the hashMap with the characters in@param {number[]} barcodes and their corresponding counts 
 *      O(n)    - populate a new array with tuples of values and count - [value, count] 
 *      O(nlogn)- sort the tuples based on theirs counts 
 *      O(n)    - append the values of the tuples starting from the most occured codes in their proper places
 *      O(nlogn)- another sorting of tuples based on the counts of the codes
 * 
 * 
 * @param {number[]} barcodes
 * @returns {number[]}
*/

// approach 1
let rearrangeBarcodes = (barcodes) => {
    let hash = new Map();
    barcodes.forEach(code => hash.has(code) ? hash.set(code,hash.get(code)+1): hash.set(code, 1));  // keep count
    let orderByCount = [...hash.entries()].sort((a,b) => b[1] - a[1]);                  // sort in an descending order

    let final = [], index=0;
    
    for (const code of orderByCount) {
        let count  = hash.get(code[0]);
        if(count > parseInt((barcodes.length+1)/2)) return []
        for(let j=0; j<parseInt(code[1]); j++){
            if(index >= barcodes.length) index = 1;
            final[index] = code[0];
            index += 2;  
        }
    }
    return final;
};

// approach 2 - too slow for big inputs
let rearrangeBarcodes2 = (barcodes) => {
    let hash = new Map();
    barcodes.forEach(code => hash.has(code) ? hash.set(code, hash.get(code)+1): hash.set(code, 1)); // populate the hash map
    let tupleList = [...hash.entries()].sort((a,b) => b[1] - a[1]);          // get an ordered tuple of the values and counts

    let final = [];

    while(tupleList.length > 0){
        let first = tupleList.shift();
        let lastVal = final[final.length-1];
        if(first[0] != lastVal){
            final.push(first[0]);
            if(first[1] != 1) tupleList.push([first[0], first[1]-1]); 
        }else{
            let second = tupleList.shift();
            if(second == null) return [];
            final.push(second[0]);
            tupleList.push(first);
            if(second[1] != 1) tupleList.push([second[0], second[1]-1]);
        }
        tupleList.sort((a,b) => b[1] - a[1]);
    }
    return final;
}