let search = (target, array) =>{
    let len = array.length;
    let left=0, right=len-1, mid;
    while(right>=left){
        mid = parseInt((right + left) / 2);
        if(array[mid] > target){
            right = mid - 1;
        }else if(array[mid] < target){
            left = mid + 1;
        }else{
            return mid;
        }
    }
    return -1;
}

let search_two = (target, array) =>{
    let len = array.length;
    let left=0, right=len-1, mid;
    while(right>left){
        mid = parseInt((right + left) / 2);
        if(array[mid] > target){
            right = mid;
        }else if(array[mid] < target){
            left = mid + 1;
        }else{
            return mid;
        }
    }
    return -1;
}


console.log(search_two(2, [-1,0,3,5,2,9,12]))