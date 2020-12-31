/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    const limit = 2147483648;
    if(x===0){
        return 0;
    }
    if(-(limit) <= x <= limit - 1){
        let ans = Math.abs(x);
        ans = ans.toString().split("");
        ans = ans.reverse().join("");
        ans = Number(ans * x/Math.abs(x));
        ans = Math.abs(ans)>limit ? 0 : ans;
        return ans;
    }
};