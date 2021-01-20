/**
 * @param {number[]} target
 * @param {number} n
 * @return {string[]}
 */
var buildArray = function(target, n) {
    // we don't need to push and pop contantly b/c it's expensive
    let operations = [];
    for(let i=1; i<=target[target.length-1]; i++){
        if(target.includes(i)){
            operations.push("Push");
            
        }else{
            operations.push("Push");
            operations.push("Pop");
        }
    }
    
    return operations;
};