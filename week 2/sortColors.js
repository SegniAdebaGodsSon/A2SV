var sortColors = function(nums) {
    function swap(i, j){
        [nums[i], nums[j]] = [nums[j], nums[i]];
    }

    let z = 0;                  // track 0
    let t = nums.length-1;      // track two
    let i = 0;                  // iterator

    if(nums.length ===1){
        return nums;
    }

    while(i<=t){
        const curr = nums[i];
        if(curr==0){
            swap(i, z);
            z++;
            i++;
        }else if(curr===2){
            swap(i, t);
            t--;
        }else{
            i++;
        }
        
    }
    return nums;
};

console.log(sortColors([0,2,2,2,0,2,1,1]))
