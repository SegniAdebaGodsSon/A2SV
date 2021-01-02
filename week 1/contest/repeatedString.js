// Complete the repeatedString function below.
function repeatedString(s, n) {
    s = s.split('');
    let newStr = "";
    for(let i=0; newStr.length<n; i++){
        newStr += s[i];
        if(i===s.length-1) 
            i = -1;
    }
    let count = 0;
    newStr = newStr.split("");
    for(let i=0; i<n; i++){
        if(newStr[i] === 'a'){
            count++;
        }
    }
    return count;
}


console.log(repeatedString('aba', 10))