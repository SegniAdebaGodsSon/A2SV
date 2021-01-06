function findMedian(arr) {      // for odd numbers
    arr = arr.sort((a,b) => a-b);       // sort the array in a non-decreasing order 
    if(arr.length%2 !== 0){
        return arr[Math.trunc(arr.length/2)];
    }
    return -1;
}