/**
 * initialize your data structure here.
 */

// SOLUTION 1
/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.values = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    if(this.values.length){
        let min = this.values[this.values.length-1][1] > x ? x : this.values[this.values.length-1][1];
        this.values.push([x, min])
        return;
    }
    this.values.push([x, x]);
    return;
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.values.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    if(this.values.length){
        let top = this.values[this.values.length-1][0];
        return top;
    }
    return;
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    if(this.values.length){
        let min = this.values[this.values.length-1][1];
        return min;
    }
    return;
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */



// SOLUTION 2
/**
 * initialize your data structure here.
 */
class MinStack {
    constructor() {
        this.values = [];
        this.mins = [];
    }
}

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    if(this.values.length){
        let min = this.mins[this.mins.length-1] > x ? x : this.mins[this.mins.length-1];
        this.values.push(x);
        this.mins.push(min);
        return;
    }
    this.values.push(x);
    this.mins.push(x);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.values.pop();
    this.mins.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.values[this.values.length-1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.mins[this.mins.length-1];
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
let obj = new MinStack();
obj.push(1);
obj.push(2);
obj.push(-4);
obj.push(-7);
obj.print();
console.log(obj.top());
obj.pop();
obj.print();
obj.pop();
obj.print();