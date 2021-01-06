var maximumToys = function(prices, k){
    prices = prices.sort((a,b) => a-b);         // sort in a non-decreasing order
    let toyNum = 0, price=prices[0];       
    while(price<k){
        toyNum++;
        price += prices[toyNum];
    }
    return toyNum;
}
let a = "33324560 77661073 31948330 21522343 97176507 5724692 24699815 12079402 6479353 28430129 42427721 57127004 26256001 29446837 65107604 9809008 65846182 8470661 13597655 360".split(" ")
console.log(maximumToys(a, 100000))