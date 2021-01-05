let bubbleSort = (arr) => {
    for(let j=arr.length-2; j>0; j--){
        for(let i=0; i<=j; i++){
            if(arr[i] > arr[i+1]){
                let curr = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = curr;
            }
        }
    }
    return arr;
}

console.log(bubbleSort([3,4,5,1,4]));

