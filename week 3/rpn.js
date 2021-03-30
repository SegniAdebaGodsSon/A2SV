/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
    let stack = [];
    function evalRPN(tokens) {
        const stack = [];
        
        for (let token of tokens) {
          if (token === '+') {
            stack.push(stack.pop()+stack.pop());
          } else if (token === '-') {
            stack.push(-stack.pop()+stack.pop());
          } else if (token === '*') {
            stack.push(stack.pop()*stack.pop());
          } else if (token === '/') {
            stack.push(Math.trunc((1/stack.pop())*stack.pop()));  // (1/stack.pop())*stack.pop() because the numenator is the second one that is popped
          } else {
            stack.push(parseInt(token));
          }
        }
        
        return stack[0];
      }
    }      