/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

var reverseList = function(head) {
    let [newHead, tail] = reverseNode(head);
    return newHead;
};
let reverseNode = function(head){
    if(head !==null && head.next === null) return [head, head]  // newHead, tail
    let [cHead, tail] = reverseNode(head.next);
    head.next = null; // to prevent cycle
    tail.next = head;
    return [cHead, head];   // old, not touched head and the new tail  
}


class ListNode {
    constructor(val, next) {
        this.val = (val === undefined ? 0 : val);
        this.next = (next === undefined ? null : next);
    }
}

let a = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4))));

console.log(reverseList(a));

