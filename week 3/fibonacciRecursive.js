/**
 * 
 * @param {number} n 
 */
let fib = (n) => {
    if(n===0) return null
    if(n === 1) return 1;
    return fib(n-1) + fib(n-2);
}
