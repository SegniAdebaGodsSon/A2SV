let selectionSort = (arr) => {
    for(let i=0; i<arr.length; i++){
        let minInd=i;
        for(let j=i+1; j<arr.length;j++){ 
            if(arr[minInd]>arr[j]) minInd = j;
        } 
        let temp = arr[i];
        arr[i] = arr[minInd];
        arr[minInd] = temp;
        
    }
    return arr;
}

console.log(selectionSort([2,3,1,1,-5,-6,77,0,5]))