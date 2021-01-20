/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let stack = [], opening = ['(', '[', '{'], closing = [')', '}', ']'];
    s = s.split('');
    for (const char of s) {
        if(opening.includes(char)){
            stack.push(char);
        }else{
            if(stack[stack.length-1] === '(' && char === ')'){
                stack.pop();
            }else if(stack[stack.length-1] === '[' && char === ']'){
                stack.pop();
            }else if(stack[stack.length-1] === '{' && char === '}'){   
                stack.pop();
            }else{
                return false;
            }
        }
    }
    console.log(stack)
    if(stack.length !== 0) return false;
    return true;
};

console.log(isValid('())'))