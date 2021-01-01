const add = require('./_1AddTwoLargeNums');
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

    num2 = "1".repeat(l1-l2) + num2;

    // change the numbers to arrays
    num1 = num1.split("");
    num2 = num2.split("");
    let total = "0", carry = 0;
    for(i=l1-1; i>=0; i--){
        let mult;
        for(j=l1-1; j>=0; j--){
            mult = Number(num2[i]) * Number(num1[j]) + carry;
            carry = ~~(mult/10);
            mult %= 10;
            mult = mult.toString();
            mult = mult.concat("0".repeat(l1-i));
        }
        total = add.addLargeNums(total, mult)
    }

    return total;
}

console.log(multiply("1", "3"))