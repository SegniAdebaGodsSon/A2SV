var addLargeNums = (num1, num2) => {
    num1 = num1.split("");
    num2 = num2.split("");
    let len = num1.length >= num2.length ? num1.length: num2.length; 
    if(num1.length > num2.length){
        num2 = "0".repeat(len-num2.length) + num2.join(""); 
        num2 = num2.split("");
    }else{
        num1 = "0".repeat(len-num1.length) + num1.join(""); 
        num1 = num1.split("");
    }

    let carry = 0, total = "";
    

    for(i=len-1; i>=0; i--){
        let sum = Number(num1[i]) + Number(num2[i]) + carry;
        carry = ~~(sum/10);
        sum = sum%10;
        total = sum.toString() + total;
    }

    if(carry > 0 ){
        total = carry + total; 
    }

    return total;

}
console.log(addLargeNums("144", "5565896"));

export {addLargeNums}