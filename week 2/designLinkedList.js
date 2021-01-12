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
        if(index === 0){
            if(this.head == null){
                return -1;
            }else{
                console.log(`get ${index}: ${this.head.value}`)
                return this.head.value;
            }
        };
        let curr = this.head, ind=1;
        while(curr.next != null && ind<index){
            curr = curr.next;
            ind++;
        }
        if(curr.next == null){
            return -1
        }
        console.log(`get ${index}: ${curr.next.value}`)
        return curr.next.value;
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
        let curr = this.head, ind=1;
        while(curr.next != null && ind<index){
            curr = curr.next;
            ind++;
        }
        if(curr.next == null){
            curr.next = new node(val);
        }else{
            let temp = curr.next;
            curr.next = new node(val);
            curr.next.next = temp;
        }
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
            return;
        }
        let curr = this.head, ind=1;
        while(curr.next != null && ind<index){
            curr = curr.next;
            ind++;
        }
        if(curr.next == null){
            curr.next = null;
        }else{
            curr.next = curr.next.next;
        }
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

