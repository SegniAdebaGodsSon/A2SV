// Complete the divisibleSumPairs function below.
function divisibleSumPairs(n, k, ar) {
    let count = 0;
    let modArray = ar.map(element => element%k);
    let modCount = new Map();
    modArray.forEach(element => {
        if(modCount.has(k-element) || (modCount.has(0) && element === 0)){
            count+= element === 0 ? modCount.get(element) : modCount.get(k-element);
        }
        if(!modCount.has(element)){ 
            modCount.set(element, 1);
        }else{
            let incremented = modCount.get(element) + 1;
            modCount.set(element, incremented);
        }     
    });
    return count;
}

console.log(divisibleSumPairs(6, 3, [1,3,2,6,1,2]));