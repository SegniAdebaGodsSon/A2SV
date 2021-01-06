var relativeSortArray = function(arr1, arr2) {
    arr1 = arr1.sort((a,b) => a-b);
    var countElem = function(arr, el){
        let count = 0;
        arr.forEach(element => {
            if(element === el) count++;    
        });
        return count;
    }
    let result = [];
    arr2.forEach(element => {
        let count = countElem(arr1, element);
        while(count>0){
            result.push(element);
            count--;
        }
    });
    arr1.forEach(element => {
        if(!arr2.includes(element)){
            result.push(element);
        }
    });
   return result;
};


console.log(relativeSortArray([2,3,1,3,2,4,6,7,9,2,19], [2,1,4,3,9,6]))