// function twoStacks(x, a, b) {
//     /*
//      * Write your code here.
//      */
//     let s1 = 0, s2 = 0, count = 0, sum = 0;
//     while((s1<a.length || s2<b.length) && sum < x){
//         if(s1<a.length && s2<b.length){
//             if(a[s1] >= b[s2]){
//                 sum += b[s2];
//                 s2++;
//                 count++;
//             }else{
//                 sum += a[s1];
//                 s1++;
//                 count++;
//             }
            
//         }else if(s1<a.length){
//             sum += a[s1];
//             s1++;
//             count++;
//         }else{
//             sum += b[s2];
//             s2++;
//             count++;
//         }
//     }
//    return count-1;
// }




function twoStacks(x, a, b){
    let sum = 0, maxSum = 0;
    let i,j = 0;
    for(i = 0; i < a.length; i++) {
        if(sum + a[i] > x) { break };
        sum += a[i];
    }
    for(j = 0; j < b.length; j++) {
        if(sum + b[j] > x) { break; }
        sum += b[j];
    }
    maxSum = i + j;
    
    while(true) {
        if(i == 0) break;
        sum -= a[--i];
        
        for(; j < b.length; j++) {
            if(sum + b[j] > x) { break; }
            sum += b[j];
        }
        maxSum = Math.max(maxSum, i+j);
    }
    return maxSum;
}

let a1 = "4 1 5 1".split(" ").map(e => Number(e));
let a2 = "2 1 0 5 5".split(" ").map(e => Number(e));

console.log(twoStacks(14, a1, a2)) // 6