/**
 * TC - O(n!)
 * @param {number} n 
 */

let recFactorial = (n) => {
    if(n === 0) return 1;
    if(n<0) return null;
    return n*recFactorial(n-1);
}
