/**
 * object accepted is assumed to be of the type {type, price}
 * we sort using the price
 * @param {type, price} arr 
 */
let countSortObj = (arr) => {
    var getMaxPrice = function(arr){
        let max = arr[0].price;
        arr.forEach(({type, price}) => {
            if(price>max){
                max=price;
            }
        });
        return max;
    }

    var fillArray = function(size){
        let arr = [];
        for (let i = 0; i < size; i++) {
            arr.push(new Array);
        }
        return arr;
    }

    let maxPrice = getMaxPrice(arr);
    let tempArr = fillArray(maxPrice+1);  // you can use [].fill().map(new Array())
    let finalArr = [];

    for (let i = 0; i < arr.length; i++) {        // populate the temp array
        tempArr[arr[i].price].push(arr[i]);
    }

    tempArr.forEach(el=>{
        if(el.length>0){
            el.forEach(obj=>{
                finalArr.push(obj);
            });
        }
    });

    return finalArr;
}



let a = [{type:'a', price:4}, {type:'b', price:2}, {type:'c', price:0}, {type:'d', price:6}]
console.log(countSortObj(a))