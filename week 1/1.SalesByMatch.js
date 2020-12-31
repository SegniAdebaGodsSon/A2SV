function sockMerchant(n, ar) {
    let socks = new Map()
        , number = 0;
    ar.forEach(sock => {
        if(!socks.has(sock)){
            socks.set(sock, 1);
        }else{
            socks.set(sock, socks.get(sock) + 1);
        }
    });
    console.log(socks)
    socks.forEach(sock => {
        number += ~~(sock/2);
    });
    
    return number;
}


let a = [1, 1, 3, 1, 2, 1, 3, 3, 3, 3];
console.log(sockMerchant(9,a));
