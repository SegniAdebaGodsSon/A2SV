/**
 * initialize your data structure here.
 */

// SOLUTION 1
class MinStack {
    constructor() {
        this.values = [];
        this.min = -Infinity;
    }
    /**
     * @param {number} x
     * @return {void}
     */
    push(x) {
        if(this.values.length){
            let min = this.min > x ? x : this.min; 
            this.min = min;
            this.values.push([x, this.min]);
            return;
        }
        this.min = x;
        this.values.push([x, x]);
    }
    /**
     * @return {void}
     */
    pop() {
        this.values.pop();
        this.min = this.values[this.values.length-1][1];
    }
    /**
     * @return {number}
     */
    top() {
        return this.values[this.values.length-1][0];
    }
    /**
     * @return {number}
     */
    getMin() {
        return this.min;
    }
    print(){
        console.log('Values: ', this.values);
        console.log('Min: ', this.min);
    }
}



// SOLUTION 2
class MinStack1{
    constructor(){
        this.mins = [];
        this.values = [];
    }

    /**
     * @param {number} x
     * @return {void}
     */
    push(x) {
        if(this.mins.length){
            let min = this.mins[this.mins.length-1] > x ? x : this.mins[this.mins.length-1];
            this.mins.push(mins);
            this.push(x);
            return;
        }
        this.mins.push(x);
        this.values.push(x);
    }
    /**
     * @return {void}
     */
    pop() {
        this.values.pop();
        this.mins.pop();
    }
    /**
     * @return {number}
     */
    top() {
        return this.values[this.values.length-1];
    }
    /**
     * @return {number}
     */
    getMin() {
        return this.mins[this.mins-1];
    }
}



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