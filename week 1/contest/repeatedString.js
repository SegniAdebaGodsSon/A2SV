// Complete the repeatedString function below.
function repeatedString(s, n) {
    let countS = (s) => {
        let count = 0;
        s.split("").forEach(element => count++);
    }

   let sLength = countS(s);
   let rem = sLength % n;
   let rep = ~~(sLength/n);
   sLength *= rep;

   for(let i=0; i<rem; i++){
       
   }
}


console.log(repeatedString('aba', 100))