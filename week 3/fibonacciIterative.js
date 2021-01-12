let fib = (n) => {
    let bb = 0, b = 1; 
    if(n===0) return 0;
    for(let i=1; i<n; i++){
        let temp = bb;
        bb=b;
        b=temp+b;
    }
    return b;
}

console.log(fib(5))