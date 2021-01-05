let insertionSort = (arr) =>{
    for (let i=1; i<arr.length; i++) {
        let j = i-1;
        let key = arr[i];
        while(j>=0 && key<arr[j]){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key; // if the key is to be inserted at 0 index, when j === -1
    }
    return arr;
}

console.log(insertionSort([4,2,6,8,1,-3]))