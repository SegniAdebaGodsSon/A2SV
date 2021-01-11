/**
 * Initialize your data structure here.
 */

class node {
    constructor(value){
        this.value = value;
        this.next = null;
    }
}


class MyLinkedList {
    constructor() {
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     * @param {number} index
     * @return {number}
     */
    get(index) {
        let curr = this.head, ind=0;
        while(curr.next() != null && ind<index){
            curr = curr.next();
            ind++;
        }
        return curr;
    }
    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     * @param {number} val
     * @return {void}
     */
    addAtHead(val) {
        if(this.head === null) return this.head = new node(val);
        let temp = this.head;
        this.head = new node(val);
        this.head.next = temp;
        return;
    }
    /**
     * Append a node of value val to the last element of the linked list.
     * @param {number} val
     * @return {void}
     */
    addAtTail(val) {
        if(this.head === null) return this.addAtHead(val);
        let curr = this.head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new node(val);
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
        let curr = this.head, prev=null, ind=0;
        while(curr.next != null && ind<index){
            prev = curr;
            curr = curr.next;
            ind++;
        }
        prev.next = new node(val);
        prev.next.next = curr;

    }
    /**
     * Delete the index-th node in the linked list, if the index is valid.
     * @param {number} index
     * @return {void}
     */
    deleteAtIndex(index) {
        if(index === 0){
            let temp = this.head.next;
            this.head = temp;
        }

        let curr = this.head, prev=null, ind=0;
        while(curr != null && ind<index){
            prev = curr;
            curr = curr.next;
            ind++;
        }
        let temp = curr.next;
        prev.next = temp;
        return;
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
 l.addAtHead(3);
 l.addAtHead(1);
 l.print()   
 l.addAtTail(66);
 l.print()
 l.addAtIndex(1, 2);
 l.print()
 l.deleteAtIndex(1)
 l.print()