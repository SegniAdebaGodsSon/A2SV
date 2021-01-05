let countingSort = (arr) =>{
    var findMax= function(arr){     // find the maximum
        let max = arr[0];
        arr.forEach(element => {
            if(max<element){
                max = element;
            }
        });
        return max;
    }
    let max = findMax(arr);
    console.log(max)
    let tempArray = new Array(max+1).fill(0);     // array of 0s, with the size of the max value of the entered array
    let finalArray = [];

    arr.forEach(element => {        // store the counts of each element
        if(tempArray[element] === 0){
            tempArray[element] = 1;
        }else{
            tempArray[element]++;
        }
    });
    console.log(tempArray)
    for (let i = 0; i < tempArray.length; i++) {
        let count = tempArray[i];
        let element = i;
        while(count>0){
            finalArray.push(i);
            count--;
        }
    }
    return finalArray;

}


console.log(countingSort([3,4,1,1,4,4,0,5,7]))