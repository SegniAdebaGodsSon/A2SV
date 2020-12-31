// import {addLargeNums} from './_1AddTwoLargeNums.js';
var subLargeNums = (num1, num2) => {
    let negative, positive;
    if(num1[0] === "-" && num2[0] === "-"){ 
        return "-" + addLargeNums(num1, num2);
    }else{
        if(num1[0] !== '-' && num2[0] === '-'){
            positive = num1;
            negative = num2;
        }else{
            positive = num2;
            negative = num1;
        }
         
    }

    negative = negative.substring(1);

    
    // add leading zeros to make the lengths similar
    positive = positive.split("");
    negative = negative.split("");
    let len = positive.length >= negative.length ? positive.length: negative.length; 
    if(positive.length > negative.length){
        negative = "0".repeat(len-negative.length) + negative.join(""); 
        negative = negative.split("");
    }else{
        positive = "0".repeat(len-positive.length) + positive.join(""); 
        positive = positive.split("");
    }
    const sign = positive.length >= negative.length ? '+' : '-'; 
    let temp;
    if(sign === '-'){
        temp = negative;
        negative = positive;
        positive = temp;
    }
    
    let carry = 0, sub = 0, total = "";
    for(i=len-1; i>=0; i--){
        sub = Number(positive[i]) - Number(negative[i]) + carry;
        carry = 0;
        if(Number(positive[i]) < Number(negative[i])){
            sub += 10 + carry;
            carry = -1;
        }
        total = sub.toString() + total;
    }

    if(sign === '-'){
        total = "-" + total;
    }
    return total;
}


console.log(subLargeNums("1", "-44"))

