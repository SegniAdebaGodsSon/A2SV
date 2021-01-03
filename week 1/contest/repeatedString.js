// Complete the repeatedString function below.
function repeatedString(s, n) {
    if(s==='a') return n;
    let countA = (s) => {
        let count = 0;
        s.split("").forEach(element => {
            if(element === 'a') count++;
            });
        return count;
    }
    let sLen=s.length, remaining=n, repetition=0, count=1, remStr;
    if(sLen < n){
        repetition = Math.trunc(n/sLen);
        remaining =  n%sLen;
    }
    remStr= s.substr(0, remaining);
    count= countA(remStr)
    if(repetition>0) count+= countA(s)*repetition; 
    
    return count;
}

