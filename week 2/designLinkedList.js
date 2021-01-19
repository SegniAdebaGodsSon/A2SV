/**
 * Initialize your data structure here.
 */

class node {
    constructor(value, next=null){
        this.value = value;
        this.next = next;
    }
}

class MyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     * @param {number} index
     * @return {number}
     */
    get(index) {
        if(index === 0){
            console.log(`get ${index}: ${this.head.value}`)
            return this.head.value || -1;
            
        };
        if(index > this.count-1) return -1;
        let curr = this.head, ind=0;
        while(ind<index){
            curr = curr.next;
            ind++;
        }
        console.log(`get ${index}: ${curr.value}`)
        return curr.value;
    }
    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     * @param {number} val
     * @return {void}
     */
    addAtHead(val) {
        this.head = new node(val, this.head);
        this.count++;
        if(this.count===1) this.tail = this.head;
        console.log('Added: ', val, 'count: ', this.count)
        console.log('head: ', this.head.value, 'tail: ', this.tail.value);
        this.print()
        return;
    }
    /**
     * Append a node of value val to the last element of the linked list.
     * @param {number} val
     * @return {void}
     */
    addAtTail(val) {
        if(this.head === null) return this.addAtHead(val);
        let temp = new node(val, null);
        this.tail.next = temp;
        this.tail=temp; 
        this.count++;
        return;
    }
    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     * @param {number} index
     * @param {number} val
     * @return {void}
     */
    addAtIndex(index, val) {
        if(index === 0) return this.addAtHead(val);
        if(index === this.count) return this.addAtTail(val);
        if(index > this.count) return -1;

        let curr = this.head, ind=0;
        while(curr.next != null && ind<index-1){
            curr = curr.next;
            ind++;
        }
        let temp = curr.next;
        curr.next = new node(val, temp);
        this.count++;
        return;
    }
    /**
     * Delete the index-th node in the linked list, if the index is valid.
     * @param {number} index
     * @return {void}
     */
    deleteAtIndex(index) {
        if(index === 0){
            let temp = this.head.next;
            this.head = temp
            this.count--;
            return;
        }
        let curr = this.head, ind=0;
        while(curr.next != null && ind<index-1){
            curr = curr.next;
            ind++;
        }
        if(curr.next == null) return -1;
        curr.next = curr.next.next;
        this.count--;
    }

    print(){
        let curr = this.head, values = [];
        if(curr == null) {
            console.log("Empty Linked List")
            return;
        }
        while(curr.next != null){
            values.push(curr.value);
            curr = curr.next;
        }
        values.push(curr.value);
        console.table(values)
    }
}



/** 
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */

let l = new MyLinkedList();
l.addAtHead(2);
l.print()
l.deleteAtIndex(1);
l.print()
l.addAtHead(222);
l.addAtHead(7);
l.addAtHead(3);
l.addAtHead(2);
l.addAtHead(5);
console.log(l.tail)
l.addAtTail(5);
l.print()
l.get(5);
// l.print()
l.deleteAtIndex(6);
l.print()
l.deleteAtIndex(4);
l.print()