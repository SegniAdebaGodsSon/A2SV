// Complete the digitSum function below.
function digitSum(n, k) {
    return super_digit(n, k, true);    
}

function super_digit(str, k=null,  first=false){
    if(str.length === 1) return str;
    let newStr;
    if(first){
        newStr = (str.split("").reduce((acc, curr) => parseInt(curr) + acc, 0) * k).toString();
    }else{
        newStr = str.split("").reduce((acc, curr) => parseInt(curr) + acc, 0).toString();
    }
    
    return super_digit(newStr);
}


let a = "148";
console.log(digitSum(a, 3));
