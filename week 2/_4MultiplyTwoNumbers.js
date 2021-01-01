const add = require('../week 1/_1AddTwoLargeNums');
let isSmaller = (num1, num2) => {
    l1 = num1.length;
    l2 = num2.length;

    if(l1>l2) return false;
    if(l1<l2) return true;
    
    // if they have the same length
    for(i=0; i<l1; i++){
        if(Number(num1[i]) > Number(num2[i])){
            return false;
        }else if(Number(num1[i]) < Number(num2[i])){
            return true;
        }
    }
    return false;
}

let multiply = (num1, num2) => {
    // make the bigger number num1
    if(isSmaller(num1, num2)){
        positive = false;
        let temp = num1;
        num1 = num2;
        num2 = temp;
    }

    l1 = num1.length;
    l2 = num2.length;


    // change the numbers to arrays
    num1 = num1.split("");
    num2 = num2.split("");
    let total = "0", carry = 0;
    for(let i=l2-1; i>=0; i--){
        let mult, line = "";
        for(j=l1-1; j>=0; j--){
            mult = Number(num2[i]) * Number(num1[j]) + carry;
            carry = ~~(mult/10);
            mult %= 10;
            mult = mult.toString();
            line = mult + line;
             
        }
        if(carry !== 0) carry.toString() + line;
        line = line.concat("0".repeat(l2-i-1));
        total = add.addLargeNums(total, line)
    }

    return total;
}

console.log(multiply("11","12" ));