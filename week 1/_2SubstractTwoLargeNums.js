const add = require('./_1AddTwoLargeNums');
var subLargeNums = (num1, num2) => {
    let positive, negative;
    if(num1[0] === "-" && num2[0] === "-"){ 
        return "-" + addLargeNums(num1, num2);
    }
    if(num1[0] === '-'){ 
        num1 = num1.substring(1);
        positive = num2;
        negative = num1;
    }
    if(num2[0] === '-') {
        num2 = num2.substring(1);
        positive = num1;
        negative = num2;
    }
 
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

    let total = 0, digit = 1, sum = 0;
    for(i=len-1; i>=0; i--, digit*=10){
        sum = ((Number(positive[i]) - Number(negative[i])) * digit);
        total += sum;
    }
    return total.toString();
}




