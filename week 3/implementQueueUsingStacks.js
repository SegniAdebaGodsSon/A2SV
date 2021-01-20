/**
 * Solution 1
 * TC - O(n) n is the length of the stack 1
 *      O(1) - push
 *      O(n) - pop
 *      O(n) - peek
 *      O(1) - empty
 */




 // Solution 1
/**
 * Initialize your data structure here.
 */
var MyQueue = function() {
    this.stack1 = [];
    this.stack2 = [];
};

/**
 * Push element x to the back of queue. 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.stack1.push(x);
    console.table(this.stack1);
};

/**
 * Removes the element from in front of queue and returns that element.
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    let iteration = this.stack1.length;
    for(let i=0; i<iteration; i++){
        this.stack2.push(this.stack1.pop());
    }
    let popped = this.stack2.pop();
    iteration = this.stack2.length;
    for(let i=0; i<iteration; i++){
        this.stack1.push(this.stack2.pop());
    }
    return popped;
};

/**
 * Get the front element.
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    let iteration =  this.stack1.length;
    for(let i=0; i<iteration; i++){
        this.stack2.push(this.stack1.pop());
    }
    console.table(this.stack2);
    let top = this.stack2[this.stack2.length-1];
    for(let i=0; i<iteration; i++){
        this.stack1.push(this.stack2.pop());
    }
    return top;
};

/**
 * Returns whether the queue is empty.
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    if(this.stack1.length) return false;
    return true;
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */