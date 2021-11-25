function countingValleys(steps, path) {
    // Write your code here
    path = path.split("");
//    console.log(path)
    let altitude = 0, valleys = 0;
    path.forEach(step => {
        step==='U' ? altitude+=1 : altitude-=1;
        if(step === 'U' && altitude == 0) valleys += 1;
    });
    return valleys;
}

let path = 'UDDDUDUU';
console.log(countingValleys(8, path));

let path2 = 'UDDDUDUUUDDU';
console.log(countingValleys(12, path2));
