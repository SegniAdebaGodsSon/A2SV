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

let findDiff = (num1, num2) =>{
    // make sure num1 is not smaller
    let positive = true;
    if(isSmaller(num1, num2)){
        positive = false;
        let temp = num1;
        num1 = num2;
        num2 = temp;
    }

    let result = "", carry = 0;

    // store length
    let l1 = num1.length;
    let l2 = num2.length;

    // reverse them
    num1 = num1.split("").reverse().join("");
    num2 = num2.split("").reverse().join("");

    // run loop till small string length and subtract digit of num1 to num2
    for(i=0; i<l2; i++){
        sub = Number(num1[i]) - Number(num2[i]) - carry;

        // if the subtraction is less than zero, we add 10 and take carry as 1
        if(sub < 0){
            sub += 10;
            carry = 1;
        }else{
            carry = 0;
        }

        result = result + sub.toString();
    }


    // subtract remaining digits of larger number
    for(i=l2; i<l1; i++){
        sub = Number(num1[i]) - carry;

        // if the value is positive make it positive
        if(sub<0){
            sub += 10;
            carry = 1;
        }else{
            carry = 0;
        }
        
        result = result + sub.toString();
    }

    result = result.split("").reverse().join("");


    if(!positive){
        result = "-" + result;
    }
    return result;

} 

console.log(findDiff("5", "44"))